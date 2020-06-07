package com.example.registerspringapp.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserProducerService {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public ResponseEntity<?> addUserModels(ArrayList<UserModel> UserModel) {
		List<ServiceInstance> instances=discoveryClient.getInstances("user-repository");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/UserModels";
		RestTemplate resttemplate = new RestTemplate();
		ResponseEntity<?> result = resttemplate.postForObject(baseUrl, UserModel, ResponseEntity.class);
		return result;
	}

	public void updateUserModel(UserModel UserModel, String uuid) {
		List<ServiceInstance> instances=discoveryClient.getInstances("user-repository");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/UserModels/"+uuid;
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", uuid);	    
		RestTemplate resttemplate = new RestTemplate();
		resttemplate.put(baseUrl, UserModel, params);
		
	}

	public void delUserModel(String uuid) {
		List<ServiceInstance> instances=discoveryClient.getInstances("user-repository");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/UserModels/"+uuid;
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", uuid);
		RestTemplate resttemplate = new RestTemplate();
		resttemplate.delete(baseUrl, params);
	}

}
