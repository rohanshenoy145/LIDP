package com.lidp.challenge.se2.controller;

import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.domain.AddressAPI;


import java.util.List;

@RestController
@RequestMapping("")
public class CustomerController {
  private final CustomerService customerService;
  private final AddressService addressService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
    this.addressService = addressService;
  }

  @PostMapping("/customers")
  public void save(@RequestBody CustomerEntity customerEntity) {
    this.customerService.save(customerEntity);
  }

  @GetMapping("/customers")
  public List<CustomerEntity> findAll() {
    return this.customerService.findAll();
  }

  @GetMapping("/customers/{id}")
  public CustomerEntity findById(@PathVariable Integer id) {
    return this.customerService.findById(id);
  }

  @DeleteMapping("/customers/{id}")
  public void deleteById(@PathVariable Integer id) {
    this.customerService.deleteById(id);
  }

  @PostMapping ("/addresses/{id}")
  public void addAddress(@PathVariable Integer id,@RequestBody AddressEntity addressEntity){
    this.addressService.addAddress(id,addressEntity);

  }

  @GetMapping ("/addresses")
  public List <AddressEntity> findAllAddresses(){
    return this.addressService.findAllAddresses();
  }

  @GetMapping("/addresses/{id}")
  public List <AddressEntity> findAddressesById(@PathVariable Integer id){
    return this.addressService.findAddresses(id);
  }

  @DeleteMapping("/addresses/{id}")
  public void deleteAddress(@PathVariable Integer id){
    this.addressService.deleteAddress(id);
  }




}
