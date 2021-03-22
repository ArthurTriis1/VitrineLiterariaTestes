/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import models.User;
import static org.junit.Assert.*;
import org.junit.Test;
import services.LoginService;
import static services.LoginService.*;
import testsUtil.AbstractBasicTest;

/**
 *
 * @author arthur
 */
public class LoginTest extends AbstractBasicTest{
    
    @Test
    public void realizaLoginComDadosCorretos(){
        User user = LoginService.loginDefault("userMock1Pass", "userMock1@ifpe.com.br");
        assertNotNull(user);
        assertEquals(user.getId(), this.loggedUserId());
    }
    
    @Test(expected = NullPointerException.class)
    public void realizaLoginSemDados(){
        User user = LoginService.loginDefault(null, null);
        assertNull(user);
        assertNull(this.loggedUserId());
    }
    
    @Test
    public void realizaLoginComDadosIncorretos(){
        User user = LoginService.loginDefault("wrongPass", "userMock1@ifpe.com.br");
        assertNull(user);
        assertNull(this.loggedUserId());
    }
    
    @Test
    public void realizaLoginComSucessoRedeSocialGoogle(){
        User user = googleClient.login("googleMockPass", "googleMock@ifpe.com.br");
        assertNotNull(user);
        assertEquals(user.getId(), this.loggedUserId());
    }
    
    @Test
    public void realizaLoginErradoRedeSocialGoogle(){
        User user = LoginService.loginWithGoogle("wrongPass", "googleMOck@ifpe.com.br");
        assertNull(user);
        assertNull(this.loggedUserId());
    }
    
    @Test
    public void realizaLoggof(){
        User user = LoginService.loginDefault("userMock1Pass", "userMock1@ifpe.com.br");
        assertNotNull(user);
        assertEquals(user.getId(), this.loggedUserId());
        
        LoginService.logoff();
        assertNull(this.loggedUserId());
    }
    
    public Long loggedUserId(){
        return LoginService.getUserLoggedId();
    }
}
