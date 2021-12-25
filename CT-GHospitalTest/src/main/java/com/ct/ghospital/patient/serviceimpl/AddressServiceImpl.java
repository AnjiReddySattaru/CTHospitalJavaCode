package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.exception.AddressException;
import com.ct.ghospital.patient.model.Address;
import com.ct.ghospital.patient.repo.AddressRepo;
import com.ct.ghospital.patient.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Override
    public List<Address> getAllAddressDetails() {
        return new ArrayList<>(addressRepo.findAll());
    }

    @Override
    public Address getAddressDetails(Integer addressId) {
        Optional<Address> address = addressRepo.findById(addressId);
        if (address.isPresent()) {
            return address.get();
        } else {
            throw new AddressException("Address with id " + addressId + " is not Present");
        }
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address updateAddress(Integer allergicid, Address address) {
        Address pAddress = getAddressDetails(allergicid);
        try {
            pAddress.setHomeAddress(address.getHomeAddress());
            pAddress.setCountry(address.getCountry());
            pAddress.setState(address.getState());
            pAddress.setPostalCode(address.getPostalCode());
            pAddress.setPhoneNumber(address.getPhoneNumber());
            return addressRepo.save(pAddress);
        } catch (AddressException addressException) {
            throw new AddressException(addressException.getMessage());
        }
    }

    @Override
    public void deleteAddress(Integer allergicid) {
        Address address = getAddressDetails(allergicid);
        addressRepo.delete(address);
    }
}
