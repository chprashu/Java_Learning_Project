package learn.testControllers;

import learn.testService.UserService;
import learn.testVOs.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<UserVO> getUser(@PathVariable String username){
        try {
            return ResponseEntity.ok(userService.getUser(username));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserVO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
