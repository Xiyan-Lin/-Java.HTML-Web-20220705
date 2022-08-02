package jdbc.service;

import java.util.Base64;

import jdbc.entity.User;
import jdbc.repository.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public int add(String username, String password) {
		User user = new User(username, password);
		return userDao.add(user);
	}
	
	public int updateUsername(Integer id, String username) {
		return userDao.updateUsername(id, username);
	}
	
	public int updatePassword(Integer id, String password) {
		// 將 password 編碼
		String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
		return userDao.updatePassword(id, encodePassword);
	}
	
	public int update(Integer id, String username, String password) {
		// 將 password 編碼
		String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
		User user = new User(username, encodePassword);
		return userDao.update(id, user);
	}
}
