package learn.testControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import learn.configurations.Security.JWTAuth.JWTService;
import learn.testService.UserService;
import learn.testVOs.UserVO;
import learn.testVTOs.AuthRequest;
import learn.testVTOs.AuthResponse;
import learn.testVTOs.UserVTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
	private JWTService jwtService;

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
	public ResponseEntity<AuthResponse> Login(@RequestBody AuthRequest authRequest) {
		AuthResponse authResponse = null;
		try {
			manager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			String token = jwtService.generateToken(authRequest.getUsername());
			authResponse = new AuthResponse(token);
			return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.NOT_FOUND);
		}
	}

}
