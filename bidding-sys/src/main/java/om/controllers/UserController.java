package om.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import om.entities.User;
import om.services.UserServiceImp;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserServiceImp userService;
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAll()   {
		return userService.getAllUsers();
	}
	
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public User create(String name, String email, String contact) {
		return userService.addUser(name, email, contact);
	}
	
}
