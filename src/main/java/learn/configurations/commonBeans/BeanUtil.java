package learn.configurations.commonBeans;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@Configuration
public class BeanUtil {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * This userDetailsService bean help us to have limited username and password,
     * but it leverages
     * use custom passwordEncoder and roles instead of using default username and
     * password.
     * 
     * once we created bean of UserDetailsService or implemented userDetailsService
     * to any external
     * services then security will authenticate user through the username which we
     * will get from
     * bean or implemented service to verify.
     */
    // @Bean
    public UserDetailsService userDetailsService(){
    	UserDetails user1 = User.builder()
    			.username("prashanth")
    			.password(passwordEncoder().encode("admin@123"))
    			.roles("USER")
    			.build();

    	return new InMemoryUserDetailsManager(user1);
    }
    
    @Bean
	@Primary
	public ObjectMapper getObjectMapper() {
		JsonFactory jsonFactory = new JsonFactory();
		ObjectMapper objectMapper = new ObjectMapper(jsonFactory);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // this is what you need
		objectMapper.setSerializationInclusion(Include.NON_NULL); // this is to not serialize unset properties
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.setTimeZone(TimeZone.getDefault());
        StdDateFormat stdDateFormat = new StdDateFormat().withTimeZone(TimeZone.getDefault());
        objectMapper.setDateFormat(stdDateFormat);
		return objectMapper;
	}
    
    /*
     * When we send username and password through request Spring Security 
     * Authentication is basically take care by AthenticationManager with 
     * default security configuration. 
     * if we want to do Authentication as we want then we have create
     *  a bean of AuthernticationManager 
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    	return configuration.getAuthenticationManager();
    }
}
