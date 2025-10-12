package learn.testService;

import learn.testVOs.UserVO;

import java.util.List;

public interface UserService {

    UserVO saveUser(UserVO userVO);

    UserVO getUser(String username);

    List<UserVO> getAllUsers();
    
}
