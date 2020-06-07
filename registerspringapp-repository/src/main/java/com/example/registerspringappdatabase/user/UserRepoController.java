package com.example.registerspringappdatabase.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRepoController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "/User" , method=RequestMethod.GET)
	public List<UserModel> getAllUserModels(){
		return userservice.getAllUserModels();
	}
	
	@RequestMapping(value = "/User/{UId}" , method=RequestMethod.GET)
	public UserModel getUserModelById(@PathVariable("UId") String uuid){
		return userservice.getUserModelById(uuid);
	}
	
	@RequestMapping(value = "/UserModels" , method=RequestMethod.POST)
	public void addUserModels(@RequestBody ArrayList<UserModel> UserModel){	
		userservice.addUserModels(UserModel);
	}
	
	@RequestMapping(value = "/UserModel/thread" , method=RequestMethod.POST)
	public void addUserModelPerThread(@RequestBody UserModel emp){	
		userservice.addUserModel(emp);
	}
	
	
	@RequestMapping(value = "/UserModels/{UID}" , method=RequestMethod.PUT)
	public void updateUserModels(@RequestBody ArrayList<UserModel> UserModel , @PathVariable("UID") String uuid){			
		userservice.updateUserModel(UserModel,uuid );
	}
	
	@RequestMapping(value = "/UserModels/{UId}" , method=RequestMethod.DELETE)
	public void delUserModels(@PathVariable("UId") String empId){		
		userservice.delUserModel(empId);
	}
}
