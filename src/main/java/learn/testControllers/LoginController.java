package learn.testControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import learn.configurations.Security.UserDetailsServiceImpl;
import learn.testService.UserService;
import learn.testVOs.UserVO;
import learn.testVTOs.AuthRequest;
import learn.testVTOs.UserVTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class LoginController {

	private ObjectMapper mapper;
    private UserService userService;
    private AuthenticationManager manager;

    @PostMapping("/register")
    public ResponseEntity<UserVO> resgister(@RequestBody UserVTO userVTO) {
    	UserVO userVO = null;
    	try {
    		userVO = userService.saveUser(mapper.convertValue(userVTO, UserVO.class));
			return new ResponseEntity<UserVO>(userVO, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(userVO, HttpStatus.BAD_REQUEST);
		}
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody AuthRequest authRequest) {
    	try {
    		Authentication authentication = manager.authenticate(
        			new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    		if(authentication.isAuthenticated()) {
        		return new ResponseEntity<String>("Success", HttpStatus.OK);
        	}else {
        		return new ResponseEntity<String>("Failed", HttpStatus.OK);
        	}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

}
