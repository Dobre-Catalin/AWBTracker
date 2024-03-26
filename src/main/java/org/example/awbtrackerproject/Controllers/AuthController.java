package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.LogInData.LogInData;
import org.example.awbtrackerproject.Model.User.User;
import org.example.awbtrackerproject.Repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AuthController {
    ///gets the user's email and password and returns the token
    @PostMapping("/login")
    public String login(@RequestBody LogInData logInData){
    return null;
    }

    Boolean checkUser(String LogInData){

        return true;
    }
}
