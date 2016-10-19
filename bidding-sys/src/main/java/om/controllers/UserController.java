package om.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import om.entities.User;
import om.services.UserServiceImp;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImp userService;
	
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public String create(String name, String email, String contact) {
		return "rahul";
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	
}
