package ku.cs.crownseal.model;


import lombok.Data;


@Data
public class SignupRequest {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

}
