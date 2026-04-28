package smartinvoice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import smartinvoice.dto.LoginRequest;
import smartinvoice.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register API
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return authService.registerUser(user);
    }

    // Login API
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {

        return authService.loginUser(request);
    }
}