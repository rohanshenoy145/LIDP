package com.lidp.challenge.se2.service.mappers;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.service.mappers.CustomerMapper;
import java.util.List;
import java.util.ArrayList;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.dao.AddressRepository;
import com.lidp.challenge.se2.persistence.dao.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddressMapper{

    final AddressRepository addressRepository;
    final CustomerRepository customerRepository;
    @Autowired
    public AddressMapper(CustomerRepository customerRepository,AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public AddressAPI toAddressAPI(AddressEntity addressEntity){
        AddressAPI addressAPI = new AddressAPI();
        addressAPI.setId(addressEntity.getId());
        addressAPI.setStreetName(addressEntity.getStreetName());
        addressAPI.setCityName(addressEntity.getCityName());
        addressAPI.setStateName(addressEntity.getStateName());
        addressAPI.setZipCode(addressEntity.getZipCode());
        CustomerAPI customerAPI = new CustomerAPI();
        customerAPI.setId(addressEntity.getCustomer().getId());
        customerAPI.setName(addressEntity.getCustomer().getName());
        addressAPI.setCustomer(customerAPI);
        return addressAPI;
    }

    public List <AddressAPI> toAddressAPIList(List <AddressEntity> addressEntities){
        List <AddressAPI> addressAPIs = new ArrayList<>();
        for(AddressEntity addressEntity : addressEntities){
            addressAPIs.add(toAddressAPI(addressEntity));
        }
        return addressAPIs;

    }





    public AddressEntity toAddressEntity(AddressAPI addressAPI){
        AddressEntity addressEntity = addressRepository.findById(addressAPI.getId()).orElse(null);
        if (addressEntity == null){
            addressEntity = new AddressEntity();
            //id will be assigned upon generated when saved in database
            addressEntity.setStreetName(addressAPI.getStreetName());
            addressEntity.setCityName(addressAPI.getCityName());
            addressEntity.setStateName(addressAPI.getStateName());
            addressEntity.setZipCode(addressAPI.getZipCode());
            //customer should be set in services

        }


        return addressEntity;

    }

    public List <AddressEntity> toAddressEntityList(List <AddressAPI> addressAPIs){
        List <AddressEntity> addressEntities = new ArrayList<>();
        for(AddressAPI addressAPI: addressAPIs){
            addressEntities.add(toAddressEntity(addressAPI));
        }
        return addressEntities;
    }


  
}