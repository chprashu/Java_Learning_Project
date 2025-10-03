package learn.configurations.Security;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
/*
 * Once we enable @EnableWebSecurity means we are telling spring
 * to fetch security configuration from here, instead of default filterChain
 * which is authenticating through csrf token.
 */
@EnableWebSecurity
// @AllArgsConstructor
public class SecurityConfig {

    // private JWTAuthenticationFilter JWTAuthenticationFilter;

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
         * either we have send csrf token manually or make it disable
         * so that server don't expect csrf token to authenticate any request
         * 
         * adding authorizeHttpRequests make every requests secure means, every requests
         * needs to be
         * authenticated to give the response.
         * 
         * This will send formLogin UI to frontend whenver you try to hit any endpoints
         */
        http.csrf(custome -> custome.disable());
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());

        /*
         * Below configuration when we JWT authentication with separte filter for
         * request authentiation
         */
        // http
        // .csrf(AbstractHttpConfigurer::disable)
        // .cors(AbstractHttpConfigurer::disable)
        // .sessionManagement(session ->
        // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // .authorizeHttpRequests(auth -> auth
        // .requestMatchers("/auth/encodePwd/**").permitAll()
        // .requestMatchers("/auth/authenticate").permitAll()
        // .requestMatchers("/auth/register").permitAll()
        // .anyRequest().authenticated())
        // .exceptionHandling(ex -> ex.authenticationEntryPoint(new
        // HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
        // .addFilterBefore(JWTAuthenticationFilter,
        // UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
