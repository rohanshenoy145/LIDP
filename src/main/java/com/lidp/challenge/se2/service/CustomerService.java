package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.persistence.dao.AddressRepository;  
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.domain.AddressAPI;
import java.util.List;
import java.util.ArrayList;




import java.util.List;

@Service
public class CustomerService {
  final CustomerRepository customerRepository;
  final AddressRepository addressRepository;


  @Autowired
  public CustomerService(CustomerRepository customerRepository,AddressRepository addressRepository) {
    this.customerRepository = customerRepository;
    this.addressRepository = addressRepository;
  }

  public void save(final CustomerEntity customerEntity) {
    List<AddressEntity> addresses = customerEntity.getAddresses();
    if (addresses != null){
      for (AddressEntity address:addresses){
        address.setCustomer(customerEntity);
      }
    }
    this.customerRepository.save(customerEntity);
  }

  public List<CustomerEntity> findAll() {
    return (List<CustomerEntity>) this.customerRepository.findAll();
  }

  public CustomerEntity findById(final Integer id) {
    final List<CustomerEntity> customers = this.findAll();

    for (final CustomerEntity customerEntity : customers) {
      if (customerEntity.getId() == id) {
        return customerEntity;
      }
    }

    throw new RuntimeException(id + " not found");
  }

  public void deleteById(final Integer id) {
    
    this.customerRepository.deleteById(id);
  }
}
