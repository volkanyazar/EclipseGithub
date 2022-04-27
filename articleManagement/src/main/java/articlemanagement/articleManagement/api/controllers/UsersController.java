package articlemanagement.articleManagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import articlemanagement.articleManagement.business.abstracts.UserService;
import articlemanagement.articleManagement.core.utilities.results.DataResult;
import articlemanagement.articleManagement.core.utilities.results.Result;
import articlemanagement.articleManagement.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getAllUsers")
	public DataResult<List<User>> getAll(){
		return this.userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@GetMapping("/getByUsername")
	public DataResult<User> getByUsername(@RequestParam String username){
		return this.userService.getByUsername(username);
	}
	
	@GetMapping("/getByUsernameAndUserType")
	public DataResult<List<User>> getByUsernameAndUserType_TypeId(@RequestParam("userName") String userName, @RequestParam("userType") int userType){
		return this.userService.getByUsernameAndUserType_TypeId(userName, userType);	
	}

}
