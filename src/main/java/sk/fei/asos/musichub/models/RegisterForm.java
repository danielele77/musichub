package sk.fei.asos.musichub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {
    private String fullName;
    private String username;
    private String email;
    private String password;
}
