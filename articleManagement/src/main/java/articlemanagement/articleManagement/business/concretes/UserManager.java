package articlemanagement.articleManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import articlemanagement.articleManagement.business.abstracts.UserService;
import articlemanagement.articleManagement.core.utilities.results.DataResult;
import articlemanagement.articleManagement.core.utilities.results.Result;
import articlemanagement.articleManagement.core.utilities.results.SuccessDataResult;
import articlemanagement.articleManagement.core.utilities.results.SuccessResult;
import articlemanagement.articleManagement.dataAccess.abstracts.UserDao;
import articlemanagement.articleManagement.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAllUsers() {
		
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Kullanıcılar başarıyla Listelendi");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı başarıyla eklendi");
	}

	@Override
	public DataResult<User> getByUserType(String typeName) {
		return new SuccessDataResult<User>
		(this.userDao.getByUserType(typeName),"Kullanıcılar başarıyla Listelendi");
	}
	
	@Override
	public DataResult<User> getByUsername(String userName) {
		return new SuccessDataResult<User>
		(this.userDao.getByUsername(userName),"Kullanıcılar başarıyla Listelendi");
	}

	@Override
	public DataResult<List<User>> getByUserIdIn(List<Integer> users) {
		return new SuccessDataResult<List<User>>
		(this.userDao.getByUserIdIn(users),"Kullanıcılar başarıyla Listelendi");
	}

	@Override
	public DataResult<List<User>> getByUserNameContains(String userName) {
		return new SuccessDataResult<List<User>>
		(this.userDao.getByUsernameContains(userName),"Kullanıcılar başarıyla Listelendi");
	}

	@Override
	public DataResult<List<User>> getByUsernameAndUserType_TypeId(String userName, int userType) {
		return new SuccessDataResult<List<User>>
		(this.userDao.getByUsernameAndUserType_TypeId(userName, userType),"Kullanıcılar başarıyla Listelendi");
	}


}
