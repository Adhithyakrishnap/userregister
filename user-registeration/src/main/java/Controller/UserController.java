package Controller;

import Model.User;
import Service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    public UserService userService;


    @PostMapping("/create")
   public ResponseEntity<User> saveUser(@RequestBody User user){
       User savedUser = userService.saveUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
   }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserById(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/validate")
    public String validateUser(@RequestBody User user) {
        // Validate the user
        if (userService.validateUser(user)) {
            return "Validation successful";
        } else {
            return "Validation failed";
        }
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
