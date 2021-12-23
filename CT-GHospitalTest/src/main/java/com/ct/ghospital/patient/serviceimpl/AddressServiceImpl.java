package com.ct.ghospital.patient.serviceimpl;

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
    public Address getAddressDetails(Integer addressId) throws Exception {
        Optional<Address> address = addressRepo.findById(addressId);
        if (address.isPresent()) {
            return address.get();
        } else {
            throw new Exception("Address is not available");
        }
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address updateAddress(Integer allergicid, Address address) throws Exception {
        Address pAddress = getAddressDetails(allergicid);
        pAddress.setHomeAddress(address.getHomeAddress());
        pAddress.setCountry(address.getCountry());
        pAddress.setState(address.getState());
        pAddress.setPostalCode(address.getPostalCode());
        pAddress.setPhoneNumber(address.getPhoneNumber());
        return addressRepo.save(pAddress);
    }

    @Override
    public void deleteAddress(Integer allergicid) throws Exception {
        Address address = getAddressDetails(allergicid);
        addressRepo.delete(address);

    }
}
