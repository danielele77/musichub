package sk.fei.asos.musichub.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.request.LoginRequest;
import sk.fei.asos.musichub.models.request.RegisterRequest;
import sk.fei.asos.musichub.models.request.UpdateProfileRequest;
import sk.fei.asos.musichub.repositories.UserManagementRepository;
import sk.fei.asos.musichub.utils.PasswordUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserManagementServiceImpl implements UserManagementService {

    private final UserManagementRepository userManagementRepository;

    @Override
    public AppUser getUserByUsername(String username) {
        AppUser appUser = userManagementRepository.findByUsername(username);

        if (appUser != null) {
            log.info("User with login {} was returned", appUser.getUsername());
            return appUser;
        } else {
            log.info("User with login {} does not exist", username);
            return null;
        }
    }

    @Override
    public AppUser getUserByEmail(String email) {
        AppUser appUser = userManagementRepository.findByEmail(email);

        if (appUser != null) {
            log.info("User with login {} was returned", appUser.getEmail());
            return appUser;
        } else {
            log.info("User with email {} does not exist", email);
            return null;
        }
    }


    @Override
    public AppUser loginUser(LoginRequest loginRequest) {
        AppUser appUserUsername = getUserByUsername(loginRequest.getUsernameEmail());
        AppUser appUserEmail = getUserByEmail(loginRequest.getUsernameEmail());

        if (appUserUsername != null) {
            log.info("User  found by username");
            if (PasswordUtil.checkPass(loginRequest.getPassword(), appUserUsername.getPassword(), appUserUsername.getSalt())) {
                return appUserUsername;
            }
        } else if (appUserEmail != null) {
            log.info("User  found by email");
            if(PasswordUtil.checkPass(loginRequest.getPassword(), appUserEmail.getPassword(), appUserEmail.getSalt())){
                return appUserEmail;
            }
        }
        log.info("User not found");
        return null;
    }

    @Override
    public boolean registerUser(RegisterRequest registerRequest) {
        String userName = registerRequest.getUsername();
        String userEmail = registerRequest.getEmail();

        AppUser appUserUsername = getUserByUsername(userName);
        AppUser appUserEmail = getUserByEmail(userEmail);

        if (appUserUsername != null) {
            log.info("User with username  {} already exits", appUserUsername);
            return false;

        }
        if (appUserEmail != null) {
            log.info("User with email  {} already exits", appUserEmail);
            return false;
        }

        String salt = PasswordUtil.genSalt();
        String hashPassword = PasswordUtil.hashPassword(registerRequest.getPassword(), salt);
        AppUser registeredUser = AppUser.builder()
                .username(userName)
                .isAdmin(false)
                .email(userEmail)
                .fullName(registerRequest.getFullName())
                .password(hashPassword)
                .salt(salt)
                .build();
        userManagementRepository.save(registeredUser);
        log.info("User with userName {} was registered", userName);
        return true;
    }

    @Override
    public AppUser updateProfile(UpdateProfileRequest updateProfileRequest) throws NotFoundException {
        long userid = updateProfileRequest.getUserId();
        Optional<AppUser> appUserOpt = userManagementRepository.findById(userid);
        if (appUserOpt.isPresent()) {
            AppUser appUser = appUserOpt.get();
            appUser.setFullName(updateProfileRequest.getFullName());
            appUser.setPhoto(updateProfileRequest.getPhoto());
            userManagementRepository.save(appUser);
            return appUser;
        }
        throw new NotFoundException();
    }


    @Override
    public AppUser getById(long userId) throws NotFoundException {
        Optional<AppUser> appUser = this.userManagementRepository.findById(userId);
        if (appUser.isPresent()) {
            return appUser.get();
        }
        throw new NotFoundException();
    }


}
