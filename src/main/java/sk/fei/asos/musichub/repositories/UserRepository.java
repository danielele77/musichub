package sk.fei.asos.musichub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fei.asos.musichub.models.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByEmail(String email);
}
