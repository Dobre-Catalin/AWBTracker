package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.Country.Country;
import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.Hub.HubDTO;
import org.example.awbtrackerproject.Model.Hub.HubResponseDTO;
import org.example.awbtrackerproject.Repositories.HubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/hubs")
@RestController
public class HubController {
    private final HubRepository repository;

    @Autowired
    public HubController(HubRepository HubRepository) {
        this.repository = HubRepository;
    }

    @PostMapping("/create")
    public HubResponseDTO createHub(@RequestBody HubDTO hubDTO){
        var hub = repository.save(toHub(hubDTO));
        var result  = repository.save(hub);
        return toHubResponseDTO(result);
    }

    @GetMapping("/show/all")
    public List<HubResponseDTO> getAllHubs(){
        var list = repository.findAll();
        return list.stream().map(this::toHubResponseDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHub(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public HubResponseDTO updateHub(@PathVariable Integer id, @RequestBody HubDTO hub){
        Hub existingHub = repository.findById(id).orElse(null);
        if(existingHub == null){
            return null;
        }

        existingHub.setZipcode(hub.ZIP());
        existingHub.setAddress(hub.address());
        existingHub.setName(hub.name());

        Country newCountry = new Country();
        newCountry.setId(hub.countryID());

        existingHub.setCountry(newCountry);


        var result =  repository.save(existingHub);
        return toHubResponseDTO(result);
    }

    Hub toHub(HubDTO hubDTO){
        Country country = new Country();
        country.setId(hubDTO.countryID());
        return new Hub(hubDTO.name(), hubDTO.ZIP(), hubDTO.address(), country);
    }

    HubResponseDTO toHubResponseDTO(Hub hub){
        return new HubResponseDTO(hub.getId(), hub.getName(), hub.getZipcode(), hub.getAddress());
    }

}
