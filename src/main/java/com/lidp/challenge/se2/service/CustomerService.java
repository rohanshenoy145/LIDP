package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void save(final CustomerEntity customerEntity) {
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
