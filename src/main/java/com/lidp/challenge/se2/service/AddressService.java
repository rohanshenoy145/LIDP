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
public class AddressService {
    final AddressRepository addressRepository;
    final CustomerRepository customerRepository;
    final AddressMapper addressMapper;
    @Autowired
    public AddressService(CustomerRepository customerRepository,AddressRepository addressRepository,AddressMapper addressMapper) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }
    
    public void addAddress(final Integer customerId, AddressAPI addressAPI ){
        CustomerEntity customer = this.customerRepository.findById(customerId).orElse(null);
        if (customer == null){
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");

        }

        AddressEntity addressEntity = addressMapper.toAddressEntity(addressAPI);
        addressEntity.setCustomer(customer);
        List<AddressEntity> addressEntities = customer.getAddresses();
        addressEntities.add(addressEntity);
        customer.setAddresses(addressEntities);
        //this.customerRepository.save(customer);
        this.addressRepository.save(addressEntity);
    }

    public List <AddressAPI> findAddresses(final Integer customerId){
        CustomerEntity customer = this.customerRepository.findById(customerId).orElse(null);
        if (customer == null){
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");

        }
        List <AddressEntity> addressEntities =  customer.getAddresses();
        return addressMapper.toAddressAPIList(addressEntities);


    }

    public List <AddressAPI> findAllAddresses(){
        List<AddressEntity> addressEntities = (List<AddressEntity>) this.addressRepository.findAll();  
        return addressMapper.toAddressAPIList(addressEntities);



    }
    public void deleteAddress(final Integer addressId){
        AddressEntity address = this.addressRepository.findById(addressId).orElse(null);
        if (address == null){
            throw new RuntimeException("Address with ID " + addressId + " does not exist");
        }
        CustomerEntity customerEntity = address.getCustomer();
        customerEntity.getAddresses().remove(address); //should delete from database too due to orphanage
        this.customerRepository.save(customerEntity);


        
    }


}