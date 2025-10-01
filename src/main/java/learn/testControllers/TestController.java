package learn.testControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> testMethod() {
        try {
            int i = 1 / 0;
            return new ResponseEntity<String>("working  " + i, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<String>("Not working", HttpStatus.BAD_GATEWAY);
        }
    }

}
