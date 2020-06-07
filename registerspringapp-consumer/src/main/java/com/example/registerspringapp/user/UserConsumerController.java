package com.example.registerspringapp.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UserConsumerController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
	@RequestMapping(value = "/UserModels", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public List<UserModel> getUserModel() throws RestClientException, IOException {
		List<ServiceInstance> instances=discoveryClient.getInstances("user-repository");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/User";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UserModel>> response=null;
		try{
			response = restTemplate.exchange(baseUrl,HttpMethod.GET,null,new ParameterizedTypeReference<List<UserModel>>(){});
			
		}catch (Exception ex)
		{
			System.out.println(ex);
		}		
		return(response.getBody());
		
		
		//Calling without eureka
		/*
		String baseUrl = "http://localhost:8092/UserModels";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UserModel>> response=null;
		try{
			response = restTemplate.exchange(baseUrl,HttpMethod.GET,null,new ParameterizedTypeReference<List<UserModel>>(){});
			
		}catch (Exception ex)
		{
			System.out.println(ex);
		}		
		return(response.getBody());
		*/
	}
	
	@RequestMapping(value = "/UserModels/{uuid}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public UserModel getUserModelById(@PathVariable("uuid") String uuid) throws RestClientException, IOException {
		List<ServiceInstance> instances=discoveryClient.getInstances("user-repository");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/User/{uuid}";		
		
		//String baseUrl = "http://localhost:8092/UserModels/{empId}";
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("uuid", uuid);	    
		RestTemplate restTemplate = new RestTemplate();		
		UserModel response=null;		
		try{
		response=restTemplate.getForObject(baseUrl, UserModel.class, params);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return(response);
	}

}
