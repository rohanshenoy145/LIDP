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
import com.lidp.challenge.se2.service.mappers.CustomerMapper;
import com.lidp.challenge.se2.service.mappers.AddressMapper;






@Service
public class CustomerService {
  final CustomerRepository customerRepository;
  final CustomerMapper customerMapper;



  @Autowired
  public CustomerService(CustomerRepository customerRepository,CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  public void save(final CustomerAPI customerAPI) {
    CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerAPI);
    this.customerRepository.save(customerEntity);
  }

  public List<CustomerAPI> findAll() {
    List <CustomerEntity> customerEntities =  (List<CustomerEntity>) this.customerRepository.findAll();
    List<CustomerAPI> customerAPIs = customerMapper.toCustomerAPIList(customerEntities);
    return customerAPIs;

  }

  public CustomerAPI findById(final Integer id) {
    CustomerEntity customerEntity = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(id + " not found"));
    
    CustomerAPI customerAPI = customerMapper.toCustomerAPI(customerEntity);
    return customerAPI;
  }

  public void deleteById(final Integer id) {
    
    this.customerRepository.deleteById(id);
  }
}
