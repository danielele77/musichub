package sk.fei.asos.musichub.models.responses;

import lombok.Data;
import sk.fei.asos.musichub.models.AppUser;


@Data
public class AppUserResponse {

    private long id;

    private String username;

    private String email;

    private String fullName;

    private Boolean isAdmin;

    private String photo;

    public AppUserResponse(AppUser appUser) {
        this.id = appUser.getId();
        this.username = appUser.getUsername();
        this.email = appUser.getEmail();
        this.fullName = appUser.getFullName();
        this.isAdmin = appUser.getIsAdmin();
        this.photo = appUser.getPhoto();
    }
}
