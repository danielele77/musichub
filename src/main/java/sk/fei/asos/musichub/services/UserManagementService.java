package sk.fei.asos.musichub.services;


import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.request.LoginRequest;
import sk.fei.asos.musichub.models.request.RegisterRequest;

public interface UserManagementService {
    AppUser getUserByUsername(String username);

    AppUser getUserByEmail(String email);
    boolean loginUser(LoginRequest loginRequest);
    boolean registerUser(RegisterRequest registerRequest) throws Exception;
}
