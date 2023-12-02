package sk.fei.asos.musichub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fei.asos.musichub.exception.NotFoundException;
import sk.fei.asos.musichub.models.AppUser;

public interface UserManagementRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);



}
