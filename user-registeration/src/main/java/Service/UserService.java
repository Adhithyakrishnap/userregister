package Service;

import Model.User;
import Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private  UserRepository userRepository;
    public User saveUser(User user) {
         return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }


    public boolean validateUser(User user) {
        // Validate the user
        return isValid(user);
    }
    private boolean isValid(User user) {
        // Replace this logic with your own validation logic
        // For example, check if the email and password exist in the database
        User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return foundUser != null;
    }
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
