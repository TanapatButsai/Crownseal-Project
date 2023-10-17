package ku.cs.crownseal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity
public class Problem {
    @Id
    @GeneratedValue
    private UUID id;


    private String nameMachine;
    private String detail;
    private LocalDateTime timestamp;
    private String location;
    private String status;

}
