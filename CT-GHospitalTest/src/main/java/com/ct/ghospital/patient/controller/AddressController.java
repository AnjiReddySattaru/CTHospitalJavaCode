package com.ct.ghospital.patient.controller;

import com.ct.ghospital.patient.exception.AddressException;
import com.ct.ghospital.patient.model.Address;
import com.ct.ghospital.patient.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;


    @GetMapping("/address")
    public List<Address> getAllAddressDetails() {
        return addressService.getAllAddressDetails();
    }

    @GetMapping("/address/{addressid}")
    public ResponseEntity<Address> getAddress(@PathVariable("addressid") Integer addressid) {
        try {
            return ResponseEntity.ok(addressService.getAddressDetails(addressid));
        } catch (AddressException ex) {
            throw new AddressException(ex.getMessage());
        }
    }

    @PostMapping("/address")
    public Address saveAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/address/{addressid}")
    public Address updateAddress(@PathVariable("addressid") Integer id, @RequestBody Address address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/address/{addressid}")
    public void deleteAddress(@PathVariable("addressid") Integer id) {
        addressService.deleteAddress(id);
    }
}
