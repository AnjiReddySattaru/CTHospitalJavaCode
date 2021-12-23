package com.ct.ghospital.patient.service;

import com.ct.ghospital.patient.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddressDetails();

    Address getAddressDetails(Integer id) throws Exception;

    Address saveAddress(Address address);

    Address updateAddress(Integer id, Address address) throws Exception;

    void deleteAddress(Integer id) throws Exception;
}
