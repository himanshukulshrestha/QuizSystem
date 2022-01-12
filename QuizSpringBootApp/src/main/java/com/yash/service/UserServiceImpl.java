package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yash.dao.UserDAO;
import com.yash.entities.User;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;

@Service
public class UserServiceImpl implements UserService{

	@Autowired@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;
	
	@Autowired@Qualifier("jdbcUserDAOImplementation")
	private UserDAO jdbcuserDAO;
	
	
	
	public List<UserResponse> getUserModel() {
		List<User> listOfUsers = userDAO.getAllUsers();
		List<UserResponse> userModelList = new ArrayList<UserResponse>();

		for (User user : listOfUsers) {
			UserResponse userModel = new UserResponse();
			userModel.setUserId(user.getUserId());
			userModel.setFirstName(user.getFirstName());
			userModel.setLastName(user.getLastName());
			userModel.setEmail(user.getEmail());
			userModel.setPassword(user.getPassword());
			//userModel.setIsAdmin(user.getIsAdmin());
			userModelList.add(userModel);
		}
		return userModelList;
	}

	@Override
	public UserResponse getUserModelByUserId(int userId) {

				User user=userDAO.getUserByUserId(userId);
				UserResponse userResponse=new UserResponse();
				userResponse.setUserId(user.getUserId());
				userResponse.setFirstName(user.getFirstName());
				userResponse.setLastName(user.getLastName());
				userResponse.setEmail(user.getEmail());
				userResponse.setPassword(user.getPassword());
			
		return userResponse;
	}
    

	@Override
	public boolean storeUserModel(UserRequest userModel) {
			
				User user=new User();
				user.setUserId(userModel.getUserId());
				user.setFirstName(userModel.getFirstName());
				user.setLastName(userModel.getLastName());
				user.setEmail(userModel.getEmail());
				user.setPassword(userModel.getPassword());
				//user.setIsAdmin(userModel.getIsAdmin());

				boolean result= jdbcuserDAO.storeUserDetails(user);
				
				if(result)
				return true;
				else
					return false;
	}

	@Override
	public boolean updatePassword(String password, int userId) {
		return userDAO.updatePassword(password, userId);
	}

	@Override
	public boolean deleteUserModelById(int userId) {
		boolean result = userDAO.deleteUserByUserId(userId);
		return result;
	}

	@Override
	public boolean authUser(String email, String password) {

		boolean result = jdbcuserDAO.authUser(email, password);
		if(result)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean updateUser(UserRequest userRequest) {
        User user=new User();
        user.setPassword(userRequest.getPassword());
        user.setUserId(userRequest.getUserId());
       
		return userDAO.updateUser(user);
	}


}
