package com.lidp.challenge.se2.service.mapper;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.service.mapper.AddressMapper;
import java.util.List;
import java.util.ArrayList;


public class CustomerMapper{

    

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
        customerAPI.setAddresses(addresses);
        return customerAPI;
    }

    public List <CustomerAPI> toCustomerAPIList(List<CustomerEntity> customerEntities){
        List<CustomerAPI> customerAPIs = new ArrayList<>();
        for(CustomerEntity customerEntity : customerEntities){
            customerAPIs.add(toCustomerAPI(cusomterEntity));
        }
        return customerAPIs;
 
    }

    public CustomerEntity toCustomerEntity(CustomerAPI customerAPI){
        CustomerEntity customerEntity =  customerRepository.findById(customerAPI.getId()).orElse(null);
        if customerEntity = null{
            customerEntity = new CustomerEntity()
            customerEntity.setId(customerAPI.getId());
            customerEntity.setName(customerAPI.getName());
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

