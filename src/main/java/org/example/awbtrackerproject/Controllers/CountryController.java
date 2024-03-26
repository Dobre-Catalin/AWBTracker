package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.Country.Country;
import org.example.awbtrackerproject.Model.Country.CountryDTO;
import org.example.awbtrackerproject.Model.Country.CountryResponseDTO;
import org.example.awbtrackerproject.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.example.awbtrackerproject.Model.Country.Country;
import org.example.awbtrackerproject.Model.Country.CountryDTO;
import org.example.awbtrackerproject.Model.Country.CountryResponseDTO;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.repository = countryRepository;
    }

    @PostMapping("/create")
    public CountryResponseDTO createCountry(@RequestBody CountryDTO countryDTO)
    {
        Country country = toCountry(countryDTO);
        var result = repository.save(country);
        return toCountryResponseDTO(result);
    }

    @GetMapping("/show/all")
    public List<CountryResponseDTO> getAllCountreis(){
        var repo = repository.findAll();
        return repo.stream().map(this::toCountryResponseDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCountry(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public CountryResponseDTO updateCountry(@PathVariable Integer id, @RequestBody Country Country){
        Country existingCountry = repository.findById(id).orElse(null);
        if(existingCountry == null){
            return null;
        }
        existingCountry.setName(Country.getName());
        existingCountry.setVignette(Country.getVignette());
        var result = repository.save(existingCountry);
        return toCountryResponseDTO(result);
    }

    private Country toCountry(CountryDTO countryDTO){
        return new Country(countryDTO.name(), countryDTO.vignette());
    }

    private CountryResponseDTO toCountryResponseDTO(Country country){
        return new CountryResponseDTO(country.getId(), country.getName(),  country.getVignette());
    }
}
