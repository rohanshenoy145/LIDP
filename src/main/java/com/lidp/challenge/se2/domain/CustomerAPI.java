import java.util.List;
package com.lidp.challenge.se2.domain;

public class CustomerAPI{
    private int id;
    private String name;
    private List<AddressAPI> addresses = new ArrayList<>(); 

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
        return addresses;

    }
    public void setAddresses(List<AddressAPI> addresses){
        this.addresses = addresses;
    }

}