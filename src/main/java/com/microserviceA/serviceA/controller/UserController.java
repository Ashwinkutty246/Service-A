package com.microserviceA.serviceA.controller;

import com.microserviceA.serviceA.model.User;
import com.microserviceA.serviceA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;

@RestController
@RequestMapping("/college")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/col")
    public User InsertDetails(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/get")
    public List<User> getDetails() {
        return userService.findall();
    }

    @GetMapping("/college_to_offfice")
    public String callOfficeService() {
        return userService.callOfficeService();
    }
    @GetMapping("/employee/{id}")
    public String getEmployeeID(@PathVariable long id) {
        return userService.findById(id);
    }
}
