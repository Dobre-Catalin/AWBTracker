package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.Transport.Transport;
import org.example.awbtrackerproject.Model.Transport.TransportDTO;
import org.example.awbtrackerproject.Model.Transport.TransportResponseDTO;
import org.example.awbtrackerproject.Model.Vehicle.Vehicle;
import org.example.awbtrackerproject.Repositories.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transports")
public class TransportController {
    private final TransportRepository repository;
    @Autowired
    public TransportController(TransportRepository transportRepository) {

        this.repository = transportRepository;
    }

    @PostMapping("/create")
    public TransportResponseDTO createUser(@RequestBody TransportDTO transport){
        Transport newTransport = toTransport(transport);
        repository.save(newTransport);
        return toTransportResponseDTO(newTransport);
    }

    @GetMapping("/show/all")
    public List<TransportResponseDTO> getAllTransports(){
        renewTransports();
        List<Transport> transports = repository.findAll();
        return transports.stream().map(this::toTransportResponseDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransport(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public TransportResponseDTO updateTransport(@PathVariable Integer id, @RequestBody TransportDTO transport){
        Transport existingTransport = repository.findById(id).orElse(null);

        if(existingTransport == null){
            return null;
        }

        Hub source = new Hub();
        source.setId(transport.sourceHubID());
        Hub destination = new Hub();
        destination.setId(transport.destinationHubID());
        existingTransport.setSourceHub(source);
        existingTransport.setDestinationHub(destination);
        existingTransport.setDepartureTime(transport.departureTime());
        existingTransport.setEstimatedDurationHours(transport.estimatedDurationHours());
        existingTransport.setEstiamtedFuelUsage(transport.estiamtedFuelUsage());
        existingTransport.setIntervalNext(transport.intervalNext());
        existingTransport.setStatus(transport.status());


        repository.save(existingTransport);
        return toTransportResponseDTO(existingTransport);
    }

    public void renewTransports() {
        for (Transport each : repository.findAll()) {
            if (each.getStatus() == "shipped") {
                Transport newTransport = each.renewTransport();
                repository.save(newTransport);
            }
        }
    }

    public Transport toTransport(TransportDTO transport){
        Transport newTransport = new Transport();
        Hub source = new Hub();
        source.setId(transport.sourceHubID());
        Hub destination = new Hub();
        destination.setId(transport.destinationHubID());
        destination.setId(transport.destinationHubID());
        newTransport.setSourceHub(source);
        newTransport.setDestinationHub(destination);
        newTransport.setDepartureTime(transport.departureTime());
        newTransport.setEstimatedDurationHours(transport.estimatedDurationHours());
        newTransport.setEstiamtedFuelUsage(transport.estiamtedFuelUsage());
        newTransport.setIntervalNext(transport.intervalNext());
        newTransport.setStatus(transport.status());
        return newTransport;
    }

    public TransportResponseDTO toTransportResponseDTO(Transport transport){
        return new TransportResponseDTO(
                transport.getId(),
                transport.getName(),
                transport.getSourceHub().getId(),
                transport.getDestinationHub().getId(),
                transport.getDepartureTime().toString(),
                transport.getEstimatedDurationHours(),
                transport.getEstiamtedFuelUsage(),
                transport.getIntervalNext(),
                transport.getStatus()
        );
    }

    public void updateStatus(@PathVariable Integer id, @RequestBody String status){
        Transport existingTransport = repository.findById(id).get();
        existingTransport.setStatus(status);
        repository.save(existingTransport);
    }
}
