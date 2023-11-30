package sk.fei.asos.musichub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fei.asos.musichub.models.AppUser;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<AppUser,Long> {
     Optional<AppUser> findByUsername(String username);
}
