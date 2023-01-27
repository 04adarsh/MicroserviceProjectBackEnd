package com.aviasoletechnologies.authenticationservice.service;
import com.aviasoletechnologies.authenticationservice.dto.AddressDTO;
import com.aviasoletechnologies.authenticationservice.exception.CustomException;
import com.aviasoletechnologies.authenticationservice.model.Address;
import com.aviasoletechnologies.authenticationservice.model.User;
import com.aviasoletechnologies.authenticationservice.model.AddressType;
import com.aviasoletechnologies.authenticationservice.repository.AddressRepository;
import com.aviasoletechnologies.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;


    @Autowired
    public UserRepository userRepository;


    public Address getAddressFromDto(AddressDTO addressDTO){
        Address ad=new Address();
        ad.setAddressLine1(addressDTO.getAddressLine1());
        ad.setAddressLine2(addressDTO.getAddressLine2());
        ad.setLandmark(addressDTO.getLandmark());
        ad.setCity(addressDTO.getCity());
        ad.setState(addressDTO.getState());
        ad.setZip(addressDTO.getZip());
        String type= addressDTO.getAddressType();
        switch (type){
            case "shipping":
                ad.setType(AddressType.SHIPPING);
                break;
            case "billing":
                ad.setType(AddressType.BILLING);
                break;
        }
        User user=this.userRepository.findById(addressDTO.getUserId()).orElseThrow(()-> new CustomException("user not found"));
        ad.setUser(user);
        return ad;

    }

    public AddressDTO addAddress(AddressDTO addressDTO){
       Address address=getAddressFromDto(addressDTO);
       this.addressRepository.save(address);
       return addressDTO;
    }

    public AddressDTO updateAddress(Long id,AddressDTO addressDTO ){
        Address address=this.addressRepository.findById(id).orElseThrow(()-> new CustomException("address not found with id:"+id));
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
       String type=addressDTO.getAddressType();
       switch (type){
           case "shipping":
               address.setType(AddressType.SHIPPING);
               break;
           case "billing":
                address.setType(AddressType.BILLING);
       }
       address.setLandmark(addressDTO.getLandmark());
       address.setState(addressDTO.getState());
       address.setZip(addressDTO.getZip());
       this.addressRepository.save(address);
       return addressDTO;

    }


}
