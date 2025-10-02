package learn.configurations.Security.JWTAuth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String roles;

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 31;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.id == null)
            return false;
        if(obj instanceof User && ((User) obj).id != null){
            return this.id == ((User) obj).id;
        }
        return false;
    }
}
