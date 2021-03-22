/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;
import repositories.UserRepository;

/**
 *
 * @author arthur
 */
public class LoginService {
    private static Long userLoggedId;

    public static Long getUserLoggedId() {
        return userLoggedId;
    }

    public static void setUserLoggedId(Long userLoggedId) {
        LoginService.userLoggedId = userLoggedId;
    }
    
    public static User loginWithGoogle(String password, String email){            
            User u = GoogleClient.login(password, email);
            
            if(u != null){
               LoginService.setUserLoggedId(u.getId());                
            }
            
            return u;
    }
    
    public static User loginDefault(String password, String email){            
            User u = UserRepository.login(password, email);
            
            if(u != null){
               LoginService.setUserLoggedId(u.getId());                
            }
            
            return u;
    }
    
    public static void logoff(){
        setUserLoggedId(null); 
    }
}
