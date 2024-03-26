package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.Parcel.Parcel;
import org.example.awbtrackerproject.Model.Parcel.ParcelDTO;
import org.example.awbtrackerproject.Model.Parcel.ParcelResponseDTO;
import org.example.awbtrackerproject.Model.User.User;
import org.example.awbtrackerproject.Model.User.UserResponseDTO;
import org.example.awbtrackerproject.Repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/parcels")
@RestController
public class ParcelController {
    private final ParcelRepository repository;

    @Autowired
    public ParcelController(ParcelRepository parcelRepository) {

        this.repository = parcelRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ParcelResponseDTO createUser(@RequestBody ParcelDTO parcelDT){
        var parcel = toParcel(parcelDT);
        var result = repository.save(parcel);
        return toParcelResponseDTO(result);
    }

    private ParcelResponseDTO toParcelResponseDTO(Parcel result) {
        return new ParcelResponseDTO(
                result.getId(),
                result.getSourceAddress(),
                result.getDestinationAddress(),
                result.getSourceZIP().toString(),
                result.getDestinationZIP().toString(),
                result.getUrgency(),
                result.getFragile(),
                result.getMass(),
                result.getHeight(),
                result.getWidth(),
                result.getLength(),
                result.getSenderPhoneNumber(),
                result.getRecepientPhoneNumber(),
                result.getAWB()
        );
    }

    private Parcel toParcel(ParcelDTO parcelDTO){
        Parcel parcel = new Parcel();
        parcel.setMass(parcelDTO.mass());
        parcel.setHeight(parcelDTO.height());
        parcel.setWidth(parcelDTO.width());
        parcel.setLength(parcelDTO.length());
        parcel.setFragile(parcelDTO.fragile());
        Double urgency = parcelDTO.paidForFastDelivery() ? 2.0 : 1.0;
        parcel.setUrgency(urgency);
        parcel.setSourceZIP(parcelDTO.sourceZIP());
        parcel.setDestinationZIP(parcelDTO.destinationZIP());
        parcel.setSourceAddress(parcelDTO.sourceAddress());
        parcel.setDestinationAddress(parcelDTO.destinationAddress());
        parcel.setSenderPhoneNumber(parcelDTO.senderPhoneNumber());
        parcel.setRecepientPhoneNumber(parcelDTO.recepientPhoneNumber());
        parcel.setAWB(createAWB(parcelDTO));

        var user = new User();
        user.setId(parcelDTO.userSendingID());
        parcel.setUserSending(user);

        return parcel;
    }

    String createAWB(ParcelDTO transferObject){
        String AWB = "";
        AWB+=transferObject.sourceZIP();
        AWB+=transferObject.destinationZIP();
        AWB += repository.count();
        return AWB;
    }

    @GetMapping("/show/all")
    public List<ParcelResponseDTO> getAllParcels(){
        System.out.println("Getting all parcels");
        List<ParcelResponseDTO> responses = new ArrayList<>();
        var repo = repository.findAll();
        for(var parcel : repo){
            System.out.println(parcel);
            responses.add(toParcelResponseDTO(parcel));
        }
        return responses;
    }

    @DeleteMapping("/delete/{id}")
    public ParcelResponseDTO deleteUser(@PathVariable Integer id){
        var response = toParcelResponseDTO(repository.findById(id).orElse(null));
        if(response != null) {
            repository.deleteById(id);
            return response;
        }
       return null;
    }

    @PutMapping("/update/{id}")
    public ParcelResponseDTO updateUser(@PathVariable Integer id, @RequestBody ParcelDTO parcel){
        Parcel existingParcel = repository.findById(id).orElse(null);
        if(existingParcel == null){
            return null;
        }
        existingParcel.setMass(parcel.mass());
        existingParcel.setHeight(parcel.height());
        existingParcel.setWidth(parcel.width());
        existingParcel.setLength(parcel.length());
        existingParcel.setFragile(parcel.fragile());
        existingParcel.setUrgency(parcel.paidForFastDelivery() ? 2.0 : 1.0);
        existingParcel.setSourceZIP(parcel.sourceZIP());
        existingParcel.setDestinationZIP(parcel.destinationZIP());
        existingParcel.setSourceAddress(parcel.sourceAddress());
        existingParcel.setDestinationAddress(parcel.destinationAddress());
        existingParcel.setSenderPhoneNumber(parcel.senderPhoneNumber());
        existingParcel.setRecepientPhoneNumber(parcel.recepientPhoneNumber());

        var result = repository.save(existingParcel);
        return toParcelResponseDTO(result);
    }
}
