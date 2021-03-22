/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.Condition;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import testsUtil.AbstractBasicTest;

/**
 *
 * @author arthur
 */
public class BookTest extends AbstractBasicTest{
   
    
    @Test
    public void PesquisaLivroPorTitulo(){
       List<Book> findBooks = bookRepository.findByTitle("Capitães da Areia");
       assertEquals(2, findBooks.size());
    }
    
    @Test
    public void PesquisaLivroPorTituloInexistente(){
       List<Book> findBooks = bookRepository.findByTitle("Livro inexistente");
       assertEquals(0, findBooks.size());
    }
    
    @Test
    public void ChecarDetalhesDeUmLivro(){
       Book book = bookRepository.findById(4L);
       assertEquals(book.getTitle(), "Supremos");
       assertEquals(book.getCondition(), Condition.NEW);
       assertEquals(book.getPublisher(), "Panini");
       assertEquals((Double) 11.00, book.getPrice());
    }
    
    @Test
    public void ChecarDetalhesDoUsuarioQuePostouOLivro(){
       Book book = bookRepository.findById(4L);
       User user = userRepository.findById(book.getUserId());
       
       
       assertEquals(user.getEmail(), "userMock1@ifpe.com.br");
       assertEquals(user.getLegalDocument(), "111.111.111-11");
       assertEquals(user.getNome(), "Arthur Andrade");
    }
    
    @Test
    public void BuscarTodosLivrosDeUmUsuario(){
        List<Book> booksByUser = bookRepository.findBooksByUserId(1L);
        assertEquals(booksByUser.size(), 2);
        assertEquals(booksByUser.get(0).getTitle(), "Capitães da Areia");
        assertEquals(booksByUser.get(1).getTitle(), "Astronauta");
    }
    
    @Test
    public void CriarNovoLivro(){
        String newTitle = "Novo Livro";
        String newPublisher = "Nova Publisher";
        Condition newCondition = Condition.MANIPULATED;
        Double newPrice = 99.00;
        Long newUser = 1L;
        Book newBook = new Book(newTitle, newPublisher, newCondition, newPrice, newUser);
        bookRepository.create(newBook);
        assertNotNull(newBook.getId());
    }
    
    @Test
    public void RemoveLivroDeUsuario() {
        boolean removed = bookRepository.deleteBook(0L, 1L);
        List<Book> booksByUser = bookRepository.findBooksByUserId(1L);
        assertEquals(removed, true);
        assertEquals(booksByUser.size(), 1);
    }
    
    @Test
    public void AtualizaDadosDeUmLivro(){
        String editedTitle = "Novo Titulo";
        Book book = bookRepository.findById(1L);
        book.setTitle(editedTitle);
        
        bookRepository.update(book);
        Book editedBook = bookRepository.findByTitle(editedTitle).get(0);
        
        assertEquals(editedBook.getTitle(), editedTitle);
    }
    
}
