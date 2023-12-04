package sk.fei.asos.musichub.services;


import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.request.LoginRequest;
import sk.fei.asos.musichub.models.request.RegisterRequest;
import sk.fei.asos.musichub.models.request.UpdateProfileRequest;

public interface UserManagementService {

    AppUser getUserByUsername(String username);

    AppUser getUserByEmail(String email);

    AppUser loginUser(LoginRequest loginRequest);

    boolean registerUser(RegisterRequest registerRequest);

    AppUser updateProfile(UpdateProfileRequest updateProfileRequest) throws NotFoundException;

    AppUser getById(long userId) throws NotFoundException;
}
