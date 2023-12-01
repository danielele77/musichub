package sk.fei.asos.musichub.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserResponse {

    private long id;

    private String email;

    private String fullName;

    private Boolean isAdmin;

    private String photo;


}
