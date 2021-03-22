/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import models.Book;

/**
 *
 * @author arthur
 */
public class BookRepository {
        private static BookRepository bookRepository;
	private List<Book> books;
        private Long actualId = 0L;
        
	
	private BookRepository() {
            this.books = new ArrayList<Book>();
	}
	
        public static BookRepository createBookRepository(){
            if(bookRepository == null){
                bookRepository = new BookRepository();
            }
            
            return bookRepository;
        }
        
	public boolean create(Book b) {
		try {
                        b.setId(this.actualId);
			this.books.add(b);
                        this.actualId++;
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
        
        public List<Book> findByTitle(String title) {
                return this.books
                        .stream()
                        .filter(book -> book.getTitle()
                        .equalsIgnoreCase(title)).collect(Collectors.toList());
	}
        
        public Book findById(Long id) {
            Book b = null;
            for (Book book : this.books) {
                if (book.getId() == id) {
                    b = book;
                }
            }		
            return b;
	}
        
        public List<Book> findBooksByUserId(Long userId){
            return this.books
                .stream()
                .filter(book -> book.getUserId()
                .equals(userId))
                .collect(Collectors.toList());
        }
        
        public boolean deleteBook (Long bookId, Long userId){
             Book bookFind = this.books
                .stream()
                .filter(book -> {
                    return book.getUserId().equals(userId) && book.getId().equals(bookId);
                })
                .collect(Collectors.toList()).get(0);
             
             if(bookFind == null){
                 return false;
             }
             
             this.books.remove(bookFind);
             return true;
        }
        
        public Book update(Book b){
            Book book = books.stream().filter(uf -> uf.getId().equals(b.getId())).collect(Collectors.toList()).get(0);
            int index = books.indexOf(book);
            books.set(index, b);
            return books.get(index);
        }
        
        public void clear(){
            this.books.clear();
            this.actualId = 0L;
        }
}
