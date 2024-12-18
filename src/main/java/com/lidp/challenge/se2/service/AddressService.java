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
public class AddressService {
    final AddressRepository addressRepository;
    final CustomerRepository customerRepository;
    @Autowired
    public AddressService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }
    
    public void addAddress(final Integer customerId, AddressEntity addressEntity ){
        CustomerEntity customer = this.customerRepository.findById(customerId);
        if customer == null{
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");

        }
        addressEntity.setCustomer(customer);
        this.addressRepository.save(addressEntity);
    }

    public List <AddressEntity> findAddresses(final Integer customerId){
        CustomerEntity customer = this.customerRepository.findById(customerId)
        if customer == null{
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");

        }
        return customer.getAddresses();


    }

    public List <AddressEntity> findAllAddresses(final Integer customerId){
        return (List<AddressEntity>) this.addressRepository.findAll();  


    }
    public void deleteAddress(final Integer addressId){
        AddressEntity address = this.addressRepository.findById(addressId)
        if address == null{
            throw new RuntimeException("Address with ID " + addressId + " does not exist");
        }

        this.addressRepository.delete(address);

        
    }
}
