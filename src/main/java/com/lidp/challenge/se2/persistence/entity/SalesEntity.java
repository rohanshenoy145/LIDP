package com.lidp.challenge.se2.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class SalesEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column
  private BigDecimal amount;

  @Column
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerEntity customer;

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

  public void setCustomer(CustomerEntity customer){
    this.customer = customer;
  }
}