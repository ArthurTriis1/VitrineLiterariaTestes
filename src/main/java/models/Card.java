/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author arthur
 */
public class Card {
    private Long number;
    private Integer cvv;
    private Date validDate;
    private String name;

    public Card(Long number, Integer cvv, String validDate, String name) throws ParseException {
        this.number = number;
        this.cvv = cvv;
        this.validDate = new SimpleDateFormat("MM/yy").parse(validDate);
        this.name = name;
    }

    
    
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
