package sk.fei.asos.musichub.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.models.LoginForm;
import sk.fei.asos.musichub.models.RegisterForm;
import sk.fei.asos.musichub.repositories.UserManagementRepository;
import sk.fei.asos.musichub.utils.PasswordUtil;

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
            log.info("User with login {} does not exist", email);
            return null;
        }
    }


    @Override
    public boolean loginUser(LoginForm loginForm) {
        AppUser appUserUsername = getUserByUsername(loginForm.getUsernameEmail());
        AppUser appUserEmail = getUserByEmail(loginForm.getUsernameEmail());

        if (appUserUsername != null) {
            log.info("Incorrect login credentials");
            return PasswordUtil.checkPass(loginForm.getPassword(), appUserUsername.getPassword(),appUserUsername.getSalt());
        } else if (appUserEmail != null) {
            log.info("Incorrect login credentials");
            return PasswordUtil.checkPass(loginForm.getPassword(), appUserEmail.getPassword(),appUserEmail.getSalt());
        }
        return false;
    }

    @Override
    public boolean registerUser(RegisterForm registerForm) throws Exception {
        String userName = registerForm.getUsername();
        String userEmail = registerForm.getEmail();

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
        String hashPassword = PasswordUtil.hashPassword(registerForm.getPassword(),salt);
        AppUser registeredUser = AppUser.builder()
                .username(userName)
                .email(userEmail)
                .fullName(registerForm.getFullName())
                .password(hashPassword)
                .salt(salt)
                .build();
        userManagementRepository.save(registeredUser);
        log.info("User with userName {} was registered", userName);
        return true;
    }
}
