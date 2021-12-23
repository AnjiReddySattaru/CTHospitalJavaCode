package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.model.Address;
import com.ct.ghospital.patient.serviceimpl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private final AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> getAllAddressDetails() {
        return addressService.getAllAddressDetails();
    }

    @GetMapping("/address/{addressid}")
    public Address getAddress(@PathVariable("addressid") Integer id) throws Exception {
        return addressService.getAddressDetails(id);
    }

    @PostMapping("/address")
    public Address saveAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/address/{addressid}")
    public Address updateAddress(@PathVariable("addressid") Integer id, @RequestBody Address address) throws Exception {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/address/{addressid}")
    public void deleteAddress(@PathVariable("addressid") Integer id) throws Exception {
        addressService.deleteAddress(id);
    }
}
