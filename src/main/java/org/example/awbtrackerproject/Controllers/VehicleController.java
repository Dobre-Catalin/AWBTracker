package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.Transport.Transport;
import org.example.awbtrackerproject.Model.Vehicle.Vehicle;
import org.example.awbtrackerproject.Model.Vehicle.VehicleDTO;
import org.example.awbtrackerproject.Model.Vehicle.VehicleResponseDTO;
import org.example.awbtrackerproject.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/vehicles")
@RestController
public class VehicleController {
    private final VehicleRepository repository;

    @Autowired
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public VehicleResponseDTO createVehicle(@RequestBody VehicleDTO vehicle){
        Vehicle newVehicle = toVehicle(vehicle);
        Vehicle savedVehicle = repository.save(newVehicle);
        var result = repository.save(savedVehicle);
        return toVehicleResponseDTO(result);
    }

    @GetMapping("/show/all")
    public List<VehicleResponseDTO> getAllVehicles()
    {
        return repository.findAll().stream().map(this::toVehicleResponseDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        repository.deleteById(id);
    }

    ///update vehicle by id
    @PutMapping("/update/{id}")
    public VehicleResponseDTO updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle){
        Vehicle existingVehicle = repository.findById(id).orElse(null);

        if(existingVehicle == null){
            return null;
        }

        existingVehicle.setOwnerHub(vehicle.getOwnerHub());
        existingVehicle.setAssignedTransport(vehicle.getAssignedTransport());
        existingVehicle.setVIN(vehicle.getVIN());
        existingVehicle.setRegistaration(vehicle.getRegistaration());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setMake(vehicle.getMake());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setDisplacement(vehicle.getDisplacement());
        existingVehicle.setMeanFuelConsumption(vehicle.getMeanFuelConsumption());
        existingVehicle.setCategory(vehicle.getCategory());
        existingVehicle.setHeight(vehicle.getHeight());
        existingVehicle.setLength(vehicle.getLength());
        existingVehicle.setWidth(vehicle.getWidth());
        existingVehicle.setGrossMass(vehicle.getGrossMass());

        repository.save(existingVehicle);

        return toVehicleResponseDTO(existingVehicle);
    }

    Vehicle toVehicle(VehicleDTO vehicle) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVIN(vehicle.VIN());
        newVehicle.setRegistaration(vehicle.registration());
        newVehicle.setMake(vehicle.make());
        newVehicle.setModel(vehicle.model());
        newVehicle.setYear(vehicle.year());
        newVehicle.setDisplacement(vehicle.displacement());
        newVehicle.setMeanFuelConsumption(vehicle.meanFuelConsumption());
        newVehicle.setCategory(vehicle.category());
        newVehicle.setHeight(vehicle.height());
        newVehicle.setLength(vehicle.length());
        newVehicle.setWidth(vehicle.width());
        newVehicle.setGrossMass(vehicle.grossMass());
        newVehicle.setMaxMass(vehicle.maxMass());
        newVehicle.setCargoWidth(vehicle.cargoWidth());
        newVehicle.setCargoLength(vehicle.cargoLength());
        newVehicle.setCargoHeight(vehicle.cargoHeight());
        Hub ownerHub = new Hub();
        ownerHub.setId(vehicle.ownerHubID());
        newVehicle.setOwnerHub(ownerHub);
        Transport assignedTransport = new Transport();
        assignedTransport.setId(vehicle.assignedTransportID());
        newVehicle.setAssignedTransport(assignedTransport);
        return newVehicle;

    }

    VehicleResponseDTO toVehicleResponseDTO(Vehicle vehicle) {
        return new VehicleResponseDTO(
                vehicle.getId(),
                vehicle.getVIN(),
                vehicle.getRegistaration(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getDisplacement(),
                vehicle.getMeanFuelConsumption(),
                vehicle.getCategory(),
                vehicle.getHeight(),
                vehicle.getLength(),
                vehicle.getWidth(),
                vehicle.getGrossMass(),
                vehicle.getMaxMass(),
                vehicle.getCargoWidth(),
                vehicle.getCargoLength(),
                vehicle.getCargoHeight(),
                vehicle.getOwnerHub().getId(),
                vehicle.getAssignedTransport().getId()
        );
    }
}
