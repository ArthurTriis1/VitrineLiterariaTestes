package models;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import enums.Condition;
import java.util.Objects;


/**
 *
 * @author arthu
 */
public class Book {
    
    private Long id;
    private String title;
    private String publisher;
    private Condition condition;
    private Double price;
    private Long authorId;

    public Book(Long id, String title, String publisher, Condition condition, Double price, Long authorId) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.condition = condition;
        this.price = price;
        this.authorId = authorId;
    }

    public Book(String title, String publisher, Condition condition, Double price, Long authorId) {
        this.title = title;
        this.publisher = publisher;
        this.condition = condition;
        this.price = price;
        this.authorId = authorId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return authorId;
    }

    public void setUserId(Long userId) {
        this.authorId = userId;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    
    public Double getPrice() {
    return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Book() {
        this.condition = Condition.NEW;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return Objects.equals(this.id, other.id);
    }
}
