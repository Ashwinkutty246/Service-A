package com.microserviceA.serviceA.service;

import com.microserviceA.serviceA.model.User;
import com.microserviceA.serviceA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        return userRepo.save(user);
    }

    public List<User> findall() {
        return userRepo.findAll();
    }

    public String callOfficeService() {
        String url = "http://office-service/office/get";
        return restTemplate.getForObject(url, String.class);
    }

//    public String findById(long id) {
//        String url="http://office-service/office/get"+id;
//        return restTemplate.getForObject(url, String.class);
//    }

    public String findById(long id) {
        // Ensure the URL is correctly formatted with the ID
        String url = "http://office-service/office/get/" + id;  // Correct URL format with "/" before id

        try {
            // Using RestTemplate to get the employee details
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            // Handle exceptions (e.g., 404, 500)
            return "An error occurred while fetching the data: " + e.getMessage();
        }
    }
}
