package com.lidp.challenge.se2.service.mapper;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.service.mapper.AddressMapper;


public class CustomerMapper{
    private final AddressMapper addressMapper;

    public CustomerMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
    }

    public CustomerAPI toCustomerAPI(CustomerEntity customerEntity){
        CustomerAPI customerAPI = new CustomerAPI();
        customerAPI.setId(customerEntity.getId());
        customerAPI.setName(customerEntity.getName());
        List <AddressAPI> addresses = this.addressMapper.toAddressAPIList(customerEntity.getAddresses())
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
        CustomerEntity customerEntity = new CustomerEntity()
        customerEntity.setId(customerAPI.getId());
        customerEntity.setName(customerAPI.getName());
        List <AddressEntity> addresses = this.addressMapper.toAddressEntityList(customerAPI.getAddresses());
        customerEntity.setAddresses(addresses);
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

