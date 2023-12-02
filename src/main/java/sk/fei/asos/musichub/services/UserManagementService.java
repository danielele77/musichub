package sk.fei.asos.musichub.services;


import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.request.LoginRequest;
import sk.fei.asos.musichub.models.request.RegisterRequest;
import sk.fei.asos.musichub.models.request.UpdateProfileRequest;
import sk.fei.asos.musichub.models.responses.AppUserResponse;

public interface UserManagementService {

    AppUser getUserByUsername(String username);

    AppUser getUserByEmail(String email);

    AppUserResponse loginUser(LoginRequest loginRequest);

    boolean registerUser(RegisterRequest registerRequest);

    boolean updateProfile(UpdateProfileRequest updateProfileRequest);

    AppUser getById(long userId) throws NotFoundException;
}
