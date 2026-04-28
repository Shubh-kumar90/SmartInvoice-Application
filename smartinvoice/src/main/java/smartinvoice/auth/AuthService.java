package smartinvoice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import smartinvoice.entity.User;
import smartinvoice.repository.UserRepository;
import smartinvoice.dto.LoginRequest;
import java.util.Optional;
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();


public String loginUser(LoginRequest request) {

    Optional<User> userOptional =
            userRepository.findByEmail(request.getEmail());

    if (userOptional.isPresent()) {

        User user = userOptional.get();

        BCryptPasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder();

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (passwordMatches) {

            return JwtUtil.generateToken(user.getEmail());
        }
    }

    return "Invalid Email or Password";
}



    // Register User
    public User registerUser(User user) {

        // Encrypt Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}