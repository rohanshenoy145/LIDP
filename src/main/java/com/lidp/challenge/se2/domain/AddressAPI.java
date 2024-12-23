import java.util.List;
package com.lidp.challenge.se2.domain;
import com.lidp.challenge.se2.domain.CustomerAPI;


public class AddressAPI{
    private int id;
    private String streetName;
    private String cityName;
    private String stateName;
    private String zipCode;
    private CustomerAPI customer;

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

  public CustomerAPI getCustomer(){
    return customer;
  }

  public void setCustomer(CustomerAPI customer ){
    this.customer = customer;

  }


}