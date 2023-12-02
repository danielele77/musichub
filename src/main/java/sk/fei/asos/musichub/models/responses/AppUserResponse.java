package sk.fei.asos.musichub.models.responses;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class AppUserResponse {

    private long id;

    private String username;

    private String email;

    private String fullName;

    private Boolean isAdmin;

    private String photo;
}
