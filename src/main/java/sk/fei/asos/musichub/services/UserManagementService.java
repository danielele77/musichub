package sk.fei.asos.musichub.services;


import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.LoginForm;
import sk.fei.asos.musichub.models.RegisterForm;

public interface UserManagementService {
    AppUser getUserByUsername(String username);

    AppUser getUserByEmail(String email);
    boolean loginUser(LoginForm loginForm);
    boolean registerUser(RegisterForm registerForm) throws Exception;

}
