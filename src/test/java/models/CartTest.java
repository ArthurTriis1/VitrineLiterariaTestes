/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import static org.junit.Assert.*;
import org.junit.Test;
import testsUtil.AbstractBasicTest;

/**
 *
 * @author arthur
 */
public class CartTest extends AbstractBasicTest{
    
    @Test
    public void AdicionaLivroNoCarrinho() {
        Cart cart = new Cart();
        
        Book book = bookRepository.findById(1L);
        Book book2 = bookRepository.findById(2L);
        
        cart.addBook(book);
        cart.addBook(book2);
        
        User user = userRepository.findById(2L);
        
        user.setCart(cart);
        
        User updatedUser = userRepository.update(user);
        
        int cartSize = updatedUser.getCart().getBooks().size();
        
        assertEquals(cartSize, 2); 
    }
    
    @Test
    public void CarrinhoIniciaVazio() {
        User user = userRepository.findById(2L);
        assertNull(user.getCart());
    }
    
    @Test
    public void UsuarioEntraNoCarroCheio(){
        User user = userRepository.findById(0L);
        
        assertEquals(user.getCart().getBooks().size(), 3);
        
        Book book1 = user.getCart().getBooks().get(0);
        
        assertEquals(book1.getTitle(), "Capitães da Areia");
    }
    
    @Test
    public void UsuarioRemoveItemDoCarro(){
        User user = userRepository.findById(1L);
        
        user.getCart().removeBook(3L);
        
        User updatedUser = userRepository.update(user);
        
        
        assertEquals(updatedUser.getCart().getBooks().size(), 2);
        
        Book book1 = user.getCart().getBooks().get(0);
        
        assertEquals(book1.getTitle(), "Supremos");
    }
}
