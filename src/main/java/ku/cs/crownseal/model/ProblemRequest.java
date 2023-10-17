package ku.cs.crownseal.model;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ProblemRequest {

    private String nameMachine;
    private String detail;
    private LocalDateTime timestamp;
    private String location;
    private String status;
}
