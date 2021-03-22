/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author arthur
 */
public class Cart {
    private List<Book> books;

    public Cart() {
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book){
        books.add(book);
    }
    
    public void removeBook(Long id){
        
        Book bookFind = books
                .stream()
                .filter(book -> book.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
        
        books.remove(bookFind);
    }
    
    public Double getTotalValue(){
        return books
                .stream()
                .map(book -> book.getPrice())
                .reduce(0., (accumulator, book) -> accumulator + book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public Payment generatePayment(){
        return new Payment(this.getTotalValue());
    }
    

}
