package com.yash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entities.User;

public interface UserDAO{
	
	public List<User> getAllUsers();
	public User getUserByUserId(int userId);
	public boolean storeUserDetails(User user);
	public boolean updatePassword(String password, int userId);
	public boolean deleteUserByUserId(int userId);
	public boolean authUser(String userName,String password);
	public boolean updateUser(User user);

}