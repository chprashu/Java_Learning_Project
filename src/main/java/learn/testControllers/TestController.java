package learn.testControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> testMethod() {
        try {
            int i = 1 / 0;
            return new ResponseEntity<String>("workin g  " + i, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Not working", HttpStatus.BAD_GATEWAY);
        }
    }

}
