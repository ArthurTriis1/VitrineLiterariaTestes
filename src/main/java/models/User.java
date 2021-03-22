/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.EmailNotMatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.ValidateEmail;

/**
 *
 * @author arthur
 */
public class User {
    private String email;
    private Integer password;
    private String nome;
    private Date bornDate;
    private String legalDocument;
    private Address address;
    private Long id;
    private Cart cart;

    public User(String email, String legalDocument, String password, String nome, String bornDate, Address address) throws ParseException, EmailNotMatchException {
        if(address == null){
            throw new NullPointerException();
        }
        
        ValidateEmail.validateEmail(email);
        this.email = email;
        this.password = password.hashCode();
        this.nome = nome;
        this.bornDate  = new SimpleDateFormat("dd/MM/yyyy").parse(bornDate);
        this.address = address;
        this.legalDocument = legalDocument;
    }

    public User(String email, String legalDocument, String password, String nome, Date bornDate, Address address, Long id) throws EmailNotMatchException {
        ValidateEmail.validateEmail(email);
        this.email = email;
        this.password = password.hashCode();
        this.nome = nome;
        this.bornDate = bornDate;
        this.address = address;
        this.legalDocument = legalDocument;
        this.id = id;
    }

    public String getLegalDocument() {
        return legalDocument;
    }

    public void setLegalDocument(String legalDocument) {
        this.legalDocument = legalDocument;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailNotMatchException {
        ValidateEmail.validateEmail(email);
        this.email = email;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
     
}
