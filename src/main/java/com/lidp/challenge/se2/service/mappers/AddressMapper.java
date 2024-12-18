package com.lidp.challenge.se2.service.mapper;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.service.mapper.CustomerMapper;
import java.util.List;
import java.util.ArrayList;




public class AddressMapper{
    private CustomerMapper customerMapper;

    public AddressMapper(CustomerMapper customerMapper){
        this.customerMapper = customerMapper;
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
        addressAPI.setCustomer(customerAPI)
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
        if addressEntity == null{
            adressEntity = new AddressEntity()
            addressEntity.setId(addressAPI.getId());
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