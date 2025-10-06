package learn.configurations.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    List<UserDetails> users = new ArrayList<>();
    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        users = List.of(
            createUser("prashanth", "user@123", "USER"),
            createUser("admin", "admin@123", "ADMIN")
        );
    }

    private UserDetails createUser(String username, String password, String role){
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(role)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
