package learn.testService.impl;

import learn.testService.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void divide() {
        int a = 1 / 0;
        System.out.println(a);
    }
}
