package com.aviasoletechnologies.authenticationservice.controller;

import com.aviasoletechnologies.authenticationservice.dto.*;
import com.aviasoletechnologies.authenticationservice.exception.CustomException;
import com.aviasoletechnologies.authenticationservice.model.User;
import com.aviasoletechnologies.authenticationservice.model.Address;
import com.aviasoletechnologies.authenticationservice.repository.AddressRepository;
import com.aviasoletechnologies.authenticationservice.repository.UserRepository;
import com.aviasoletechnologies.authenticationservice.service.AddressService;
import com.aviasoletechnologies.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private AddressRepository addressRepository;


   @Autowired
   private AddressService addressService;


   public AddressDTO getAddressDTO(Address address){
       AddressDTO addressDTO=new AddressDTO();
       addressDTO.setAddressId(address.getId());
       addressDTO.setAddressLine1(address.getAddressLine1());
       addressDTO.setAddressLine2(address.getAddressLine2());
       addressDTO.setLandmark(address.getLandmark());
       addressDTO.setAddressType(address.getType().toString());
       addressDTO.setCity(address.getCity());
       addressDTO.setUserId(address.getUser().getId());
       addressDTO.setState(address.getState());
       addressDTO.setZip(address.getZip());
       return addressDTO;

   }
    @GetMapping("/get")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = this.userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId){
       User user=this.userRepository.findById(userId).orElseThrow(()-> new CustomException("user not found"));

        List<AddressDTO> addressDTOList=new ArrayList<>();
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setAddressList(addressDTOList);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping("/getCurrentUser")
    public ResponseEntity<UserDTO> getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String username= auth.getName();
        System.out.println(username);

       User userResp=this.userRepository.findByUsername(username).orElseThrow(()-> new CustomException("user not found with username"+username));

        List<Address> addressList=userResp.getAddresss();
        List<AddressDTO> addressDTOList=new ArrayList<>();

        UserDTO userDTO=new UserDTO();
        userDTO.setId(userResp.getId());
        userDTO.setUsername(userResp.getUsername());
        userDTO.setAddressList(addressDTOList);

        if(addressList.size()>0){

            for(Address address:addressList){
                AddressDTO addressDTO=getAddressDTO(address);
                addressDTOList.add(addressDTO);

            }

        }

        return ResponseEntity.ok(userDTO);


    }

    @PostMapping("/address")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO addressDTO){

        AddressDTO resp= this.addressService.addAddress(addressDTO);
        if(resp==null){
            return ResponseEntity.badRequest().body("address not added");
        }
        return ResponseEntity.ok(new AddressRespDTO("address added successfully.."));

    }


    /*
        this a method to get the address using userId of the user
        userId will pe passed as PathVariable and then the address will be found using userID
     */

    @GetMapping("/address/get/{userId}")
    public ResponseEntity<?> getAddressFromUserId(@PathVariable("userId") Long userId){
         List<Address> addressList=this.addressRepository.findAddressByUserId(userId);

         List<AddressDTO> addressDTOList=new ArrayList<>();


         if(addressList.size()>0){

             for(Address address:addressList){
                 AddressDTO addressDTO=getAddressDTO(address);
                 addressDTOList.add(addressDTO);

             }

         }

        return ResponseEntity.ok(addressDTOList);

    }

    @PutMapping("/address/{addressId}")
    public ResponseEntity<?> addressUpdate(@PathVariable("addressId") Long addressId, @RequestBody AddressDTO addressDTO) {
        AddressDTO address = this.addressService.updateAddress(addressId, addressDTO);
        if (address == null) {
            return ResponseEntity.badRequest().body("address not updated");
        }
        return ResponseEntity.ok(new AddressRespDTO("address updated successfully"));
    }

//    @DeleteMapping("/delete/{userId}")
//    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
//        this.userService.deleteUser(userId);
//        return ResponseEntity.ok(new DeleteResponse("user deleted successfully"));
//    }


}

