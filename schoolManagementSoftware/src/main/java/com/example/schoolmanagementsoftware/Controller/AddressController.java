package com.example.schoolmanagementsoftware.Controller;


import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/Address")
@AllArgsConstructor

public class AddressController {

    private final AddressService addressService;

    @GetMapping("/getAllAddress")
    public ResponseEntity<List<Address>> getAllDetails() {
        List<Address> customerDetailsList = addressService.getAllAddress();
        return ResponseEntity.status(200).body(customerDetailsList);

    }

    @PostMapping("/addAddress")
    public ResponseEntity addDetailsCustomer(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("The address added");
    }


    @PutMapping("/updateAddress/{id}")
    public ResponseEntity updateDetailsCustomer(@RequestBody @Valid AddressDTO addressDTO, @PathVariable Integer id) {
        addressService.UpdateAddress(addressDTO);
        return ResponseEntity.status(200).body("the address Details has been changed ");
    }



}
