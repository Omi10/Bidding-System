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
	
	/*@Override
	public UserModel updateUser(int userId, User user) {
		UpdateUserModel user = userUtils.mapUpdateUser(userId, user);
		return user;
	}*/
	
}

