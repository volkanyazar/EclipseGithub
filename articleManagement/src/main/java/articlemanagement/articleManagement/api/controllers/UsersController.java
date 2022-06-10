package articlemanagement.articleManagement.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import articlemanagement.articleManagement.business.abstracts.UserService;
import articlemanagement.articleManagement.core.entities.User;
import articlemanagement.articleManagement.core.utilities.results.DataResult;
import articlemanagement.articleManagement.core.utilities.results.ErrorDataResult;

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
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(userService.add(user));
	}
	
	@GetMapping("/getByUsername")
	public DataResult<User> getByUsername(@RequestParam String username){
		return this.userService.getByUsername(username);
	}
	
	@GetMapping("/getByUsernameAndUserType")
	public DataResult<List<User>> getByUsernameAndUserType_TypeId(@RequestParam("userName") String userName, @RequestParam("userType") int userType){
		return this.userService.getByUsernameAndUserType_TypeId(userName, userType);	
	}
	
	@GetMapping("/findByEmail")
	public DataResult<User> findByEmail(@RequestParam String email){
		return this.userService.findByEmail(email);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hatası meydana geldi");
		return errors;
	}

}
