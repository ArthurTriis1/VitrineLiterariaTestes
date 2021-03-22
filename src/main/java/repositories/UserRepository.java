/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import services.LoginService;



/**
 *
 * @author arthur
 */
public class UserRepository {

        private static UserRepository userRepository;
	private static List<User> users;
        private Long actualId = 0L;
        
	
	private UserRepository() {
            this.users = new ArrayList<User>();
	}
	
        public static UserRepository createUserRepository(){
            if(userRepository == null){
                userRepository = new UserRepository();
            }
            
            return userRepository;
        }
        
	public boolean create(User u) {
		try {
                        u.setId(this.actualId);
			this.users.add(u);
                        this.actualId++;
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
        
        public User findByLegalDocument(String legalDocument) {
		User u = null;
		for (User user : this.users) {
			if (user.getLegalDocument().equals(legalDocument)) {
				u = user;
			}
		}		
		return u;
	}
        
        public User findById(Long id) {
		User u = null;
		for (User user : this.users) {
			if (user.getId().equals(id)) {
				u = user;
			}
		}		
		return u;
	}
	
        public static User login(String password, String email){
            if(password == null || email == null){
                throw new NullPointerException();
            }
            
            User u = null;
            for (User user : users) {
                    if (user.getEmail().equals(email) && user.getPassword() == password.hashCode()) {
                            u = user;
                    }
            }
            
            return u;
        }
        
        public void clear(){
            this.users.clear();
            this.actualId = 0L;
        }
        
        public User update(User u){
            User user = users.stream().filter(uf -> uf.getId().equals(u.getId())).collect(Collectors.toList()).get(0);
            int index = users.indexOf(user);
            users.set(index, u);
            return users.get(index);
        }
}

