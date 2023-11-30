package sk.fei.asos.musichub.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sk.fei.asos.musichub.config.AuthUser;
import sk.fei.asos.musichub.models.AppUser;
import sk.fei.asos.musichub.repositories.UserRepository;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        AppUser user  = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        System.out.println(user.getUsername());
        return new AuthUser(user.getUsername(),user.getPassword());
    }
}
