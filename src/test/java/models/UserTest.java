package models;


import enums.BrazilianStates;
import exceptions.EmailNotMatchException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;
import testsUtil.AbstractBasicTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthur
 */
public class UserTest extends AbstractBasicTest{
    
    @Test
    public void CriaUsuarioValido() throws EmailNotMatchException {
        try{
            User user = new User(
            "arthurandrade@ifpe.com.br",
            "705.820.634-18",
            "12345arthur",
            "Arthur Andrade",
            "27/04/1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
                )
            );

            userRepository.create(user);
            assertNotNull(user.getId());
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
        
    } 
    
    @Test(expected = ParseException.class)
    public void CriaUsuarioComDataDeNascimentoInvalida() throws ParseException, EmailNotMatchException{
        try{
          User user = new User(
            "arthurandrade@ifpe.com.br",
            "705.820.634-18",
            "12345arthur",
            "Arthur Andrade",
            "27 de Abril de 1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
                )
            );  
          
          userRepository.create(user);
          assertNotNull(user.getId());
        }catch(ParseException ex){
            throw ex;
        }        
    } 
    
    @Test(expected = EmailNotMatchException.class)
    public void CriaUsuarioComEmailInvalido() throws EmailNotMatchException, ParseException{
        try{
            User user = new User(
            "arthurfelipe",
            "705.820.634-18",
            "12345arthur",
            "Arthur Andrade",
            "27/04/1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
                )
            );

            userRepository.create(user);
            assertNotNull(user.getId());
        } catch(EmailNotMatchException e){
            throw e;
        }
    } 
    
    @Test
    public void UsuarioCancelaCadastro() throws ParseException, EmailNotMatchException{
        User user = new User(
            "arthurandrade@ifpe.com.br",
            "705.820.635-19",
            "12345arthur",
            "Arthur Andrade",
            "27/04/1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
                )
            );
        
        assertNull(user.getId());
        User unfindUser = userRepository.findByLegalDocument("705.820.635-19");
        assertNull(unfindUser);
    } 
    
    @Test(expected = NullPointerException.class)
    public void UsuarioNaoPreencheEndereço() throws ParseException, EmailNotMatchException{
        try{
            User user = new User(
            "arthurandrade@ifpe.com.br",
            "705.820.635-19",
            "12345arthur",
            "Arthur Andrade",
            "27/04/1999",
            null);
        }catch(NullPointerException ex){
            throw ex;
        }
    } 
    
    @Test
    public void AtualizaDadosDoUsuario(){
        String editedEmail = "userEditedMock@ifpe.edu.br";
        
        User user = userRepository.findByLegalDocument("111.111.111-11");
        try {
            user.setEmail(editedEmail);
        } catch (EmailNotMatchException ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        userRepository.update(user);
        User editedUser = userRepository.findByLegalDocument("111.111.111-11");
        
        assertEquals(editedUser.getEmail(), editedUser.getEmail());
    }
    
    @Test(expected = EmailNotMatchException.class)
    public void AtualizaEmailDoUsuarioInvalido() throws EmailNotMatchException{
        String editedEmail = "emailError";
        
        User user = userRepository.findByLegalDocument("111.111.111-11");
        try {
            user.setEmail(editedEmail);
        } catch (EmailNotMatchException ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
