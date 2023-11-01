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

    private String locationName;
    private String locationDetail;
    private String district;
    private String province;
    private String postalCode;
}
