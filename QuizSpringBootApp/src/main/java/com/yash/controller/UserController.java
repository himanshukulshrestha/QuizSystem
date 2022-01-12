package com.yash.controller;

import java.util.List;



import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.User;
import com.yash.model.QuestionsResponse;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;
import com.yash.service.UserServiceImpl;

@RestController
@RequestMapping("userapi")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("users")
	public ResponseEntity<List<UserResponse>> handleGetAllUserJSON(){
		
		List<UserResponse> UserResponseList=userService.getUserModel();
		ResponseEntity<List<UserResponse>> response=null;
		if(!UserResponseList.isEmpty()) {
		 response=new ResponseEntity<List<UserResponse>>(UserResponseList,HttpStatus.OK);
		}else {
			response=new ResponseEntity<List<UserResponse>>(UserResponseList,HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}
	
	@GetMapping("userById/{userId}")
	public ResponseEntity<UserResponse> handleGetUserByIdJSON(@PathVariable("userId") int userId)
	{
		ResponseEntity<UserResponse> response=null;
		UserRequest userRequest = new UserRequest();
		userRequest.setUserId(userId);
        UserResponse userResponse = userService.getUserModelByUserId(userId);
        
		if(userResponse.getUserId()!=0) {
			response=new ResponseEntity<UserResponse>(userResponse,HttpStatus.FOUND);
		}else {
			response=new ResponseEntity<UserResponse>(userResponse,HttpStatus.NOT_FOUND);

		}
	        
		return response;
		
	}
	
	@PostMapping("postUser")
	public ResponseEntity<UserResponse> storeUserModel(@RequestBody UserRequest userRequest){
		ResponseEntity<UserResponse> response=null;

		boolean result=userService.storeUserModel(userRequest);
		if(result) {
			UserResponse userResponse=new UserResponse();
			userResponse.setUserId(userRequest.getUserId());
			userResponse.setFirstName(userRequest.getFirstName());
			userResponse.setLastName(userRequest.getLastName());
			userResponse.setEmail(userRequest.getEmail());
			userResponse.setPassword(userRequest.getPassword());
		}else {
			response=new ResponseEntity<UserResponse>(HttpStatus.CREATED);
		}
		return response;
		
	}
	
	@PatchMapping("users")
	public ResponseEntity<Void> updateUserPassword(@RequestBody UserRequest userRequest){
		
		
		boolean result=userService.updatePassword(userRequest.getPassword(), userRequest.getUserId());
		ResponseEntity<Void> response=null;
		if(result) {
			response=new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else {
			response=new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}
		return response;
	}
	
	@PutMapping("user")
	public ResponseEntity<String> updateuserpassword(@RequestBody UserRequest userRequest)
	{
		boolean result=userService.updateUser(userRequest);
		
		ResponseEntity<String> response=null;
		if(result) {
			response=new ResponseEntity<String>("User password updated.",HttpStatus.ACCEPTED);
		}else {
			response=new ResponseEntity<String>("User password update failed",HttpStatus.NOT_MODIFIED);
		}
		return response;
	}
	
	@DeleteMapping("deleteUser/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId")int userId){
	boolean result=userService.deleteUserModelById(userId);
	ResponseEntity<Void> response=null;
	if(result) {
	response=new ResponseEntity<Void>(HttpStatus.OK);
	}else {
	response=new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	return response;
	}
	
	@PostMapping("authuser")
	public ResponseEntity<String> authUser(@RequestBody UserRequest userRequest){
	boolean result=userService.authUser(userRequest.getEmail(),userRequest.getPassword());
	ResponseEntity<String> response=null;
	if(result) {
		response=new ResponseEntity<String>("Login Successfull",HttpStatus.OK);
	}else {
		response=new ResponseEntity<String>("Login failed",HttpStatus.NOT_FOUND);
	}
	return response;
	
	}
}
