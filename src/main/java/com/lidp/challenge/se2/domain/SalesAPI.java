import java.util.List;
package com.lidp.challenge.se2.domain;
import com.lidp.challenge.se2.domain.CustomerAPI;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesAPI{
    private int id;
    private BigDecimal amount;
    private LocalDate date;
    private CustomerAPI customer;
    
    public int getId(){
    return this.id;
  }

  public int setId(int id){
    this.id = id;
  }

  public BigDecimal getAmount(){
    return this.amount;
  }

  public void setAmount(BigDecimal amount){
    this.amount = amount;
  }

  public LocalDate getDate(){
    return this.date;
  }

  public void setDate(LocalDate date){
    this.date = date;
  }

  public CustomerEntity getCustomer(){
    return this.customer;
  }

  public void setCustomer(CustomerAPI customer){
    this.customer = customer;
  }
}