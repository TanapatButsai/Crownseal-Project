package ku.cs.crownseal.model;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ProblemRequest {

    private String machineNumber;
    private String subject;
    private String detail;
    private LocalDateTime timestamp;
    private String status;
}
