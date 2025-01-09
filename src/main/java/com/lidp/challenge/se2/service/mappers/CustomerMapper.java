package com.lidp.challenge.se2.service.mappers;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.domain.SalesAPI;

import com.lidp.challenge.se2.service.mappers.AddressMapper;
import java.util.List;
import java.util.ArrayList;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.dao.AddressRepository;
import com.lidp.challenge.se2.persistence.dao.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper{

    final AddressRepository addressRepository;
    final CustomerRepository customerRepository;
    @Autowired
    public CustomerMapper(CustomerRepository customerRepository,AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }
    

    public CustomerAPI toCustomerAPI(CustomerEntity customerEntity){
        CustomerAPI customerAPI = new CustomerAPI();
        customerAPI.setId(customerEntity.getId());
        customerAPI.setName(customerEntity.getName());
        List <AddressAPI> addresses = new ArrayList<>();
        for (AddressEntity addressEntity : customerEntity.getAddresses()) {
            AddressAPI addressAPI = new AddressAPI();
            addressAPI.setId(addressEntity.getId());
            addressAPI.setStreetName(addressEntity.getStreetName());
            addressAPI.setCityName(addressEntity.getCityName());
            addressAPI.setStateName(addressEntity.getStateName());
            addressAPI.setZipCode(addressEntity.getZipCode());
            addresses.add(addressAPI);
        }
        List <SalesAPI> sales = new ArrayList<>();
        for(SalesEntity salesEntity: customerEntity.getSales()){
            SalesAPI salesAPI = new SalesAPI();
            salesAPI.setId(salesEntity.getId());
            salesAPI.setAmount(salesEntity.getAmount());
            salesAPI.setDate(salesEntity.getDate());
            sales.add(salesAPI);

        }
        customerAPI.setAddresses(addresses);
        customerAPI.setSales(sales);
        return customerAPI;
    }

    public List <CustomerAPI> toCustomerAPIList(List<CustomerEntity> customerEntities){
        List<CustomerAPI> customerAPIs = new ArrayList<>();
        for(CustomerEntity customerEntity : customerEntities){
            customerAPIs.add(toCustomerAPI(customerEntity));
        }
        return customerAPIs;
 
    }

    public CustomerEntity toCustomerEntity(CustomerAPI customerAPI){
        CustomerEntity customerEntity =  customerRepository.findById(customerAPI.getId()).orElse(null);
        if (customerEntity == null){
            customerEntity = new CustomerEntity();
            //id will be assigned by generated when saved in database
            customerEntity.setName(customerAPI.getName());
            //addresses initially empty 
            //sales initially empty
        }
        return customerEntity;
    }

    public List <CustomerEntity> toCustomerEntityList(List <CustomerAPI> customerAPIs){
        List <CustomerEntity> customerEntities =  new ArrayList<>();
        for(CustomerAPI customerAPI: customerAPIs){
            customerEntities.add(toCustomerEntity(customerAPI));
        }
        return customerEntities;
    }
}

