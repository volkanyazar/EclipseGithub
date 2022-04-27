package articlemanagement.articleManagement.business.abstracts;

import java.util.List;

import articlemanagement.articleManagement.core.utilities.results.DataResult;
import articlemanagement.articleManagement.core.utilities.results.Result;
import articlemanagement.articleManagement.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAllUsers();
	Result add(User user);
	
	DataResult<User> getByUsername(String userName);
	
	DataResult<User> getByUserType(String typeName);
	
	DataResult<List<User>> getByUserIdIn(List<Integer> users);
	
	DataResult<List<User>> getByUserNameContains(String userName);
	
	//@Query("From User where username=:userName and userType=:userType")
	DataResult<List<User>> getByUsernameAndUserType_TypeId(String userName, int userType);

}
