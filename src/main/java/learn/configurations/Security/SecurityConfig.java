package learn.configurations.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
/*
 * Once we enable @EnableWebSecurity means we are telling spring
 * to fetch security configuration from here, instead of default filterChain
 * which is authenticating through csrf token.
 */
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
         * here we have configure the SecurityFilterChain where SecurityFilterChain is
         * the main reson for the request authentication
         *
         * To return SecurityFilterChain we have to use any implemented class of
         * SecurityFilterChain. HttpSecurity is one of the implemented class of
         * SecurityFilterChain(Polymorphism).
         */

        /*
         * if we are not using default security configs
         * either we have to send csrf token manually or make it disable
         * so that server don't expect csrf token to authenticate any request
         */
        http.csrf(custome -> custome.disable());
        /*
        authorizeRequests is used to configure what request should be authenticated,
        what requests can be accessible without authentication.
         */
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        /*
        formLogin sends UI a form to login with default values
        or we can configure externally through db
         */
          // http.formLogin(Customizer.withDefaults());
        /*
        To enable the REST APIs excess we have to mention which security we are using
        here we are going to use basic authentication like httpBasic
         */
//        http.httpBasic(Customizer.withDefaults());
        /*
        With the above configuration security become non-stateless means
        once form login success it will generate a JSESSIONID which will be saved browser
        cookie further requests will be sent by attaching JSESSIONID through browser,
        since non-stateless it will save JSESSIONID to make it stateless
        we can use below configuration.
         */
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        /*
        if we have @bean of UserDetailsService to authenticate username and password using basic auth
        we can remove Customizer.withDefaults() inside httpBasic
         */
        http.httpBasic();
        /*
        if we have custom UserDetailsService to authenticate username and password using basic auth
        we have mention where we are implementing by giving service class name
         */
        http.userDetailsService(userDetailsService);

        return http.build();
    }
}
