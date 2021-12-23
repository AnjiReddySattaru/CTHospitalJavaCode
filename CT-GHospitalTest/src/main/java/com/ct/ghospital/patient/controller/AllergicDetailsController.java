package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.AllergicDetails;
import com.ct.ghospital.patient.serviceimpl.AllergicDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllergicDetailsController {

    @Autowired
    private AllergicDetailsServiceImpl allergicDetailsServiceImpl;

    @GetMapping("/allergic")
    public List<AllergicDetails> getAllAllergicDetails() {
        return allergicDetailsServiceImpl.getAllAllergicDetails();
    }

    @GetMapping("/allergic/{allergicid}")
    public AllergicDetails getAllergicDetails(@PathVariable("allergicid") Integer allergicid) throws Exception {
        return allergicDetailsServiceImpl.getAllergicDetails(allergicid);
    }

    @PostMapping("/allergic")
    public AllergicDetails saveAllergicDetails(@RequestBody AllergicDetails allergicDetails) {
        return allergicDetailsServiceImpl.saveAllergicDetails(allergicDetails);
    }

    @PutMapping("/allergic/{allergicid}")
    public AllergicDetails updateAllergicDetails(@PathVariable("allergicid") Integer allergicid, @RequestBody AllergicDetails allergicDetails) throws Exception {
        return allergicDetailsServiceImpl.updateAllergicDetails(allergicid, allergicDetails);
    }

    @DeleteMapping("/allergic/{allergicid}")
    public void deleteAllergicDetails(@PathVariable("allergicid") Integer allergicid) throws Exception {
        allergicDetailsServiceImpl.deleteAllergicDetails(allergicid);
    }
}
