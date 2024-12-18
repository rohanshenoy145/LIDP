package com.lidp.challenge.se2.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "address")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  @Column
  private int id;

  @Column
  private String streetName;

  @Column
  private String cityName;

  @Column 
  private String stateName;

  @Column 
  private String zipCode;

  @ManyToOne
  @JoinColumn(name = "customer_id",nullable = false)
  private CustomerEntity customer;

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getStreetName(){
    return streetName;
  }
  
  public void setStreetName(String streetName){
    this.streetName = streetName;
  }

  public String getCityName(){
    return cityName;
  }
  
  public void setCityName(String cityName){
    this.cityName = cityName;
  }

  public String getStateName(){
    return stateName;
  }
  
  public void setStateName(String stateName){
    this.stateName = stateName;
  }
  
  public String getZipCode(){
    return zipCode;
  }
  
  public void setZipCode(String zipCode){
    this.zipCode = zipCode;
  }

  public CustomerEntity getCustomer(){
    return customer;
  }

  public void setCustomer(CustomerEntity customer ){
    this.customer = customer;

  }
  


  


}