package learn.testVTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVTO extends BaseVTO {

    private String username;

    private String password;

    private String roles;
}