package learn.configurations.Security.JWTAuth;

import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
// @Service
public class JpaUserDetaiilsService implements UserDetailsService {

    List<User> users = new ArrayList<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> first = this.users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        return first.map(user -> org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .build()).orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " Not Found"));
    }

    public User registerUser(User user) {
        users.add(user);
        return user;
    }

    public boolean checkUser(User user) {
        return users.contains(user);
    }

    public User getUser(Integer id) {
        Optional<User> first = users.stream().filter(user -> user.getId() == id).findFirst();
        return first.orElse(null);
    }

}
