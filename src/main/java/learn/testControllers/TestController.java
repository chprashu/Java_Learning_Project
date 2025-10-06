package learn.testControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import learn.testVTOs.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    public ResponseEntity<String> testMethod() {
        try {
            int i = 1 / 0;
            return new ResponseEntity<String>("working  " + i, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<String>("Not working", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/apiTest")
    public String getMethodName(HttpServletRequest request) {
        return "working with ID: " + request.getSession().getId();
    }

    @GetMapping("/csrfTest")
    public CsrfToken csrfTestMethod(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    @PostMapping("/testPostMethod")
    public AuthRequest testPost(@RequestBody AuthRequest request) {
        return request;
    }

}
