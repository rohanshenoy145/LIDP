package com.lidp.challenge.se2.service.mapper;
import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.domain.SalesAPI;

import com.lidp.challenge.se2.service.mapper.CustomerMapper;
import java.util.List;
import java.util.ArrayList;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.dao.AddressRepository;
import com.lidp.challenge.se2.persistence.dao.SalesRepository;
import java.time.LocalDate;





@Component
public class SalesMapper{
    final CustomerRepository customerRepository;
    final SalesRepository salesRepository;
    @Autowired
    public SalesMapper(CustomerRepository customerRepository,SalesRepository salesRepository) {
        this.customerRepository = customerRepository;
        this.salesRepository = salesRepository;
    }

    public SalesAPI toSalesAPI(SalesEntity salesEntity){
        SalesAPI salesAPI = new SalesAPI();
        salesAPI.setId(salesEntity.getId());
        salesAPI.setAmount(salesEntity.getAmount());
        salesAPI.setDate(salesEntity.getDate());
        CustomerAPI customerAPI = new CustomerAPI();
        customerAPI.setId(salesEntity.getCustomer().getId());
        customerAPI.setName(salesEntity.getCustomer().getName());
        //not sure about the addressAPI, you can just query customer if u want addresses
        salesAPI.setCustomer(customerAPI);
        return salesAPI;

    }

    public List <SalesAPI> toSalesAPIList(List<SalesEntity> salesEntities){
        List <SalesAPI> salesAPIs = new ArrayList<>();
        for(SalesEntity salesEntity: salesEntities){
            salesAPIs.add(toSalesAPI(salesEntity));
        }
        return salesAPIs;

    }

    public SalesEntity toSalesEntity(SalesAPI salesAPI){
        SalesEntity salesEntity = salesRepository.findById(salesAPI.getId()).orElse(null);
        if (salesEntity == null){
            salesEntity = new SalesEntity();
            //id will be assigned upon generated when saved in database
            salesEntity.setAmount(salesAPI.getAmount());
            salesEntity.setDate(salesAPI.getDate());
            //customer should be set in services
        }
        return salesEntity;
    }

    public List <SalesEntity> toSalesEntityList(List <SalesAPI> salesAPIs){
        List <SalesEntity> salesEntities = new ArrayList<>();
        for(SalesAPI salesAPI: salesAPIs){
            salesEntities.add(toSalesEntity(salesAPI));
        }
        return salesEntities;

    }

}
