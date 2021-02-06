package demo.Controller;

import demo.Status;
import demo.Model.User;
import demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        System.out.println(newUser);
        List<User> users = userRepository.findAll();

        if (newUser.getEmail() == null) return Status.FAILURE;

        for (User user: users) {
            if (user.equals(newUser) && user.getEmail().equals(newUser.getEmail())) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        System.out.println(user);

        for (User other : users) {
            System.out.println(other);
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}
