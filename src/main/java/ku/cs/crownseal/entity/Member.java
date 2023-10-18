package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String name;
    private String role;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "member") // "member" is the name of the field in the PurchaseOrder class
    private List<Problem> ProblemList = new ArrayList<>();


}