package com.example.registerspringappdatabase.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired	
	private UserRepository userRepository; 
	
	public List<UserModel> getAllUserModels(){	
		ArrayList<UserModel> list = new ArrayList<>();
		userRepository.findAll().forEach(list::add);
		return list;
	}
	public UserModel getUserModelById(String uuid){
		return userRepository.findById(uuid).get();
	}
	public void addUserModels(List<UserModel> UserModel) {
		userRepository.saveAll(UserModel);
	}
	public void updateUserModel(List<UserModel> UserModel, String uuid){		
		userRepository.deleteById(uuid);
		userRepository.saveAll(UserModel);
	}
	public void delUserModel(String uuid){	
		userRepository.deleteById(uuid);
	}
	public void addUserModel(UserModel uuid) {
		userRepository.save(uuid);		
	}

}
