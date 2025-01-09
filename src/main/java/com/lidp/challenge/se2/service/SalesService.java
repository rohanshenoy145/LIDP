package com.lidp.challenge.se2.service;
import com.lidp.challenge.se2.persistence.dao.AddressRepository;  
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.persistence.entity.SalesEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.dao.SalesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lidp.challenge.se2.domain.CustomerAPI;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.domain.SalesAPI;

import java.util.List;
import java.util.ArrayList;
import com.lidp.challenge.se2.service.mappers.CustomerMapper;
import com.lidp.challenge.se2.service.mappers.AddressMapper;
import com.lidp.challenge.se2.service.mappers.SalesMapper;

@Service
public class SalesService{
    final SalesRepository salesRepository;
    final CustomerRepository customerRepository;
    final SalesMapper salesMapper;
    @Autowired
    public SalesService(CustomerRepository customerRepository,SalesRepository salesRepository,SalesMapper salesMapper) {
        this.customerRepository = customerRepository;
        this.salesRepository = salesRepository;
        this.salesMapper = salesMapper;
    }
    public void addSale(final Integer customerId,SalesAPI salesAPI){
        CustomerEntity customer = this.customerRepository.findById(customerId).orElse(null);
        if (customer == null){
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");

        }
        SalesEntity salesEntity = salesMapper.toSalesEntity(salesAPI);
        salesEntity.setCustomer(customer);
        List <SalesEntity> salesEntities = customer.getSales();
        salesEntities.add(salesEntity);
        customer.setSales(salesEntities);
        this.customerRepository.save(customer);
        this.salesRepository.save(salesEntity); 
    }

    public List<SalesAPI> findSales(final Integer customerId){
        CustomerEntity customer = this.customerRepository.findById(customerId).orElse(null);
        if (customer == null){
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");

        }
        List <SalesEntity> salesEntities = customer.getSales();
        return salesMapper.toSalesAPIList(salesEntities);        

    }
    //first
    public BigDecimal getTotalSalesByCustomer(final Integer customerId){
        CustomerEntity customer = this.customerRepository.findById(customerId).orElse(null);
        if (customer == null){
            throw new RuntimeException("Customer with ID " + customerId + " does not exist");
        }
        List<SalesEntity> sales = customer.getSales();

        BigDecimal total = BigDecimal.ZERO;
        for(SalesEntity sale:sales){
            total = total.add(sale.getAmount());

        }
        total = total.setScale(2, RoundingMode.HALF_UP);
        return total;
    }
    //second
    public List<SalesAPI> getSalesByDate(LocalDate startDate,LocalDate endDate){
        List<SalesEntity> salesEntities = (List<SalesEntity>) salesRepository.findAll();
        List<SalesAPI> salesAPI = new ArrayList<>();
        for(SalesEntity salesEntity: salesEntities){
            LocalDate date = salesEntity.getDate();
            if(!date.isBefore(startDate) && !date.isAfter(endDate)){
                salesAPI.add(salesMapper.toSalesAPI(salesEntity));
            }
        } 
        return salesAPI;


    }
    //third
    public BigDecimal getTotalSalesByDate(LocalDate startDate,LocalDate endDate){
        List<SalesEntity> salesEntities = (List<SalesEntity>) salesRepository.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for(SalesEntity salesEntity:salesEntities){
            LocalDate date = salesEntity.getDate();
            if(!date.isBefore(startDate) && !date.isAfter(endDate)){
                total = total.add(salesEntity.getAmount());
            }
        }
        total = total.setScale(2, RoundingMode.HALF_UP);
        return total;





    }

}