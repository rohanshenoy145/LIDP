package com.lidp.challenge.se2.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column
  private String name;


  @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
  private List <AddressEntity> customerAddresses;

  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AddressEntity> getAddresses(){
    return customerAddresses;
  }

  public void setAddresses(List<AddressEntity>customerAddresses){
    this.customerAddresses = customerAddresses
  }




}
