package om.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import om.dao.UserDaoImp;
import om.entities.User;
import om.models.UserModel;

@Service
public class UserServiceImp {
	
	@Autowired
	UserDaoImp userDaoImp;
	
	
	public List<User> getAllUsers() {
		List<User> users = userDaoImp.getAll();
		return users;
	}
	
	public User addUser(String name, String email, String contact) {
		User user = new User(name, email, contact);
		userDaoImp.save(user);
		return user;
	}
	
		
}

