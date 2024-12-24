import java.util.List;
package com.lidp.challenge.se2.domain;
import java.util.List;
import java.util.ArrayList;
import com.lidp.challenge.se2.domain.AddressAPI;
import com.lidp.challenge.se2.domain.SalesAPI;


public class CustomerAPI{
    private int id;
    private String name;
    private List<AddressAPI> addresses = new ArrayList<>();
    private List<SalesAPI> sales = new ArrayList<>();
 

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<AddressAPI> getAddresses(){
        return this.addresses;

    }
    public void setAddresses(List<AddressAPI> addresses){
        this.addresses = addresses;
    }

    public List<SalesAPI> getSales(){
        return this.sales;
    }

    public void setSales(List<SalesAPI> sales){
        this.sales = sales;
    }



}