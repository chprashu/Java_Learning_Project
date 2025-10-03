package learn.configurations.Security.JWTAuth;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import learn.configurations.Security.DTOs.AuthRequest;

import java.util.List;

// @RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    private JpaUserDetaiilsService jpaUserDetaiilsService;
    private JWTService jwtService;
    private AuthenticationManager authManager;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        if (jpaUserDetaiilsService.checkUser(user)) {
            return new ResponseEntity<>(jpaUserDetaiilsService.getUser(user.getId()), HttpStatus.OK);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<User>(jpaUserDetaiilsService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/encodePwd")
    public ResponseEntity<String> getEncodedPassword(@RequestParam("password") String password) {
        return ResponseEntity.ok(passwordEncoder.encode(password));
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return jpaUserDetaiilsService.getUsers();
    }

}
