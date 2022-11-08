package tn.esprit.spring.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IServiceUser;

import java.util.List;

@EnableSwagger2
@Api(tags = "Users Management")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    IServiceUser serviceUser;

    @ResponseBody
    @GetMapping("/showUsers")
    public List<User> getUsers(){
        return serviceUser.retrieveAllUsers();
    }

    @GetMapping("/showUser/{username}")
    @ResponseBody
    public UserDetails getUser(@PathVariable String username){
        return serviceUser.loadUserByUsername(username);
    }

    @PutMapping("/modifyUser/{id}")
    @ResponseBody
    public User modifyUser(@PathVariable int id) {

        return serviceUser.updateUser(id);
    }


    @DeleteMapping("/removeUser/{id}")
    @ResponseBody
    public void removeArticle(@PathVariable Integer id) {

        serviceUser.deleteUser(id);
    }


    @GetMapping("/loyalUser")
    public List<String> loyalUser(){

        return serviceUser.loyalUser();
    }

}


