package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.AllergyDetailsException;
import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.service.AllergicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AllergicDetailsController {

    @Autowired
    private AllergicDetailsService allergicDetailsService;

    @GetMapping("/allergic")
    public List<AllergicDetails> getAllAllergicDetails() {
        return allergicDetailsService.getAllAllergicDetails();
    }
    
    @GetMapping("/allergicbytype/{allergytype}")
    public List<AllergicDetails> getAllAllergicDetails(@PathVariable("allergytype") String allergytype) {
    	
        return allergicDetailsService.getAllergicDetailsByType(allergytype);
    }
    
    @GetMapping("/allergicbyname/{allergyname}")
    public List<AllergicDetails> getAllergicDetailsByName(@PathVariable("allergyname") String allergyname) {
    	
        return allergicDetailsService.getAllergicDetailsByName(allergyname);
    }
    
    @GetMapping("/allergicbydescription/{allergydescription}")
    public List<AllergicDetails> getAllergicDetailsDescription(@PathVariable("allergydescription") String allergydescription) {
    	
        return allergicDetailsService.getAllergicDetailsDescription(allergydescription);
    }
    
    @GetMapping("/allergicbyclinicalinfo/{allergyclinicalinfo}")
    public List<AllergicDetails> getAllergicDetailsClinicalInfo(@PathVariable("allergyclinicalinfo") String allergyclinicalinfo) {
    	
        return allergicDetailsService.getAllergicDetailsClinicalInfo(allergyclinicalinfo);
    }

    @GetMapping("/allergic/{allergicid}")
    public ResponseEntity<AllergicDetails> getAllergicDetails(@PathVariable("allergicid") Integer allergicid) {
        try {
            return ResponseEntity.ok(allergicDetailsService.getAllergicDetails(allergicid));
        } catch (AllergyDetailsException ex) {
            throw new AllergyDetailsException(ex.getMessage());
        }

    }

    @PostMapping("/allergic")
    public AllergicDetails saveAllergicDetails(@RequestBody AllergicDetails allergicDetails) {
        return allergicDetailsService.saveAllergicDetails(allergicDetails);
    }

    @PutMapping("/allergic/{allergicid}")
    public AllergicDetails updateAllergicDetails(@PathVariable("allergicid") Integer allergicid, @RequestBody AllergicDetails allergicDetails) {
        return allergicDetailsService.updateAllergicDetails(allergicid, allergicDetails);
    }

    @DeleteMapping("/allergic/{allergicid}")
    public void deleteAllergicDetails(@PathVariable("allergicid") Integer allergicid){
        allergicDetailsService.deleteAllergicDetails(allergicid);
    }
}
