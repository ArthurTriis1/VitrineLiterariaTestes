/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enums.BrazilianStates;
import exceptions.EmailNotMatchException;
import interfaces.services.ISocialNetworkService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import models.Address;
import models.User;

/**
 *
 * @author arthur
 */
public class GoogleClient implements ISocialNetworkService{
        private static GoogleClient googleClient;
	private static List<User> users;
	
	private GoogleClient() {
            this.users = new ArrayList<User>();
	}
	
        public static GoogleClient createUserRepository(){
            if(googleClient == null){
                googleClient = new GoogleClient();
                try{
                    users.add(new User(
                    "googleMock@ifpe.com.br",
                    "333.333.333-33",
                    "googleMockPass",
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
                    ));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            }
            
            return googleClient;
        }
        
	
        public static User login(String password, String email){
            if(password == null || email == null){
                throw new NullPointerException();
            }
            
            User u = null;
            // Simulação da pesquisa no sistema do google
            
            for (User user : users) {
                    if (user.getEmail().equals(email) && user.getPassword() == password.hashCode()) {
                            u = user;
                    }
            }
            
            if(u != null){
               LoginService.setUserLoggedId(u.getId());                
            }
            
            return u;
        }
}
