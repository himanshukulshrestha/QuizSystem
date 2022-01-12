package com.yash.service;


import java.util.List;

import com.yash.entities.User;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;


public interface UserService {
	
	public List<UserResponse> getUserModel();
	public UserResponse getUserModelByUserId(int userId);
	public boolean storeUserModel(UserRequest user);
	public boolean updatePassword(String password, int userId);
	public boolean deleteUserModelById(int userId);
	public boolean authUser(String userName, String password);
	public boolean updateUser(UserRequest userRequest);


	

}
