package articlemanagement.articleManagement.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import articlemanagement.articleManagement.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
		User getByUserType(String typeName);
		
		User getByUsername(String userName);
		
		User findByEmail(String email);
		
		List<User> getByUserIdIn(List<Integer> users);
		
		List<User> getByUsernameContains(String userName);
		
		@Query("From User where username=:userName and userType.typeId=:userType")
		List<User> getByUsernameAndUserType_TypeId(String userName, int userType);
	
}
