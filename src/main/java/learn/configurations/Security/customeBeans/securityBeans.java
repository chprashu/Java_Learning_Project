package learn.configurations.Security.customeBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class securityBeans {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
    This userDetailsService bean help us to have limited username and password, but it leverages
    use custom passwordEncoder and roles instead of using default username and password.

    once we created bean of UserDetailsService or implemented userDetailsService to any external
    services then security will authenticate user through the username which we will get from
    bean or implemented service to verify.
     */
//    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder()
                .username("prashanth")
                .password(passwordEncoder().encode("admin@123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }
}
