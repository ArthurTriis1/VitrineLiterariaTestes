/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.BrazilianStates;

/**
 *
 * @author arthu
 */
public class Address {
    
    private String street;
    private String district;
    private Integer number;
    private String complement;
    private String postalCode;
    private String city;
    private BrazilianStates state;

    public Address(String street, String district, Integer number, String complement, String postalCode, String city, BrazilianStates state) {
        this.street = street;
        this.district = district;
        this.number = number;
        this.complement = complement;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
    }

    
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public BrazilianStates getState() {
        return state;
    }

    public void setState(BrazilianStates state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
