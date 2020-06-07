package com.example.registerspringapp.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserProducerController {
	
	@Autowired
	private UserProducerService userProducerService;
	
	@RequestMapping(value = "/UserModel" , method=RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void addUserModel(@RequestBody ArrayList<UserModel> UserModel){			
		userProducerService.addUserModels(UserModel);		
	}

	@RequestMapping(value = "/UserModels/{id}" , method=RequestMethod.PUT)
	public void updateUserModels(@RequestBody ArrayList<UserModel> UserModel , @PathVariable("id") String id){		
		userProducerService.updateUserModel(UserModel.get(0),id );
	}
	
	@RequestMapping(value = "/UserModels/{id}" , method=RequestMethod.DELETE)
	public void delUserModels(@PathVariable("id") String id){		
		userProducerService.delUserModel(id);
	}


}
