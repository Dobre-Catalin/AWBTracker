package org.example.awbtrackerproject.Controllers;

import org.example.awbtrackerproject.Model.User.User;
import org.example.awbtrackerproject.Model.User.UserDTO;
import org.example.awbtrackerproject.Model.User.UserResponseDTO;
import org.example.awbtrackerproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;
    @Autowired
    public UserController(UserRepository userRepository) {

        this.repository = userRepository;
    }

    public User searchUserForLogin(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public UserResponseDTO createUser(@RequestBody UserDTO user){
        var newUser = toUser(user);
        System.out.println(user.email());
        var result = repository.save(newUser);
        return toUserResponseDTO(result);

    }

    private User toUser(UserDTO user){
        return new User(user.email(), user.password(), user.isAdmin(), user.isSender(), user.isViewOnly());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/show/all")
    public List<UserResponseDTO> getAllUsers(){
        List<User> repo = repository.findAll();
        List<UserResponseDTO> responses = new ArrayList<>();
        for(User user : repo){
            System.out.println(user.getEmail());
            responses.add(toUserResponseDTO(user));
        }
        return responses;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public UserResponseDTO deleteUser(@PathVariable Integer id){
        var response = toUserResponseDTO(repository.findById(id).orElse(null));
        if(response != null) {
            repository.deleteById(id);
            return response;
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update/{id}")
    public UserResponseDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userDT){
        User user = this.toUser(userDT);
        User existingUser = repository.findById(id).orElse(null);
        if(existingUser == null){
            return null;
        }
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAdmin(user.getAdmin());
        existingUser.setSender(user.getSender());
        existingUser.setViewOnly(user.getViewOnly());
        repository.save(existingUser);
        return toUserResponseDTO(existingUser);
    }

    UserResponseDTO toUserResponseDTO(User user){
        return new UserResponseDTO(user.getEmail(), user.getPassword(), user.getAdmin(), user.getSender(), user.getViewOnly(), user.getId());
    }
}
