package sk.fei.asos.musichub.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.asos.musichub.models.request.LoginRequest;
import sk.fei.asos.musichub.models.request.RegisterRequest;
import sk.fei.asos.musichub.services.UserManagementService;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserManagementController {

    private final UserManagementService userManagementService;

//    @GetMapping("/{userName}")
//    public ResponseEntity<Object> getUser(@PathVariable("userName") String login) {
//        AppUser userData = userManagementService.getUserByUsername(login);
//
//        if (userData != null) {
//            return ResponseEntity.ok(new AppUserResponse(userData));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws IOException {
        if (userManagementService.loginUser(loginRequest)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Incorrect user credentials");
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) throws Exception {
        boolean registrationSuccessful = userManagementService.registerUser(registerRequest);
        return registrationSuccessful ? ResponseEntity.ok("User successfully registered") : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
