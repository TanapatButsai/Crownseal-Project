package ku.cs.crownseal.entity;

import jakarta.persistence.*;
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
    private String subject;
    private String detail;
    private LocalDateTime timeStampStart;
    private LocalDateTime timeStampFinish;
    private String status;

    private String locationName;
    private String locationDetail;
    private String district;
    private String province;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "member_id") // "member_id" is the foreign key column in the PurchaseOrder table
    private Member member;

    @OneToOne(mappedBy = "problem")
    private WorkOrder workOrder;


}
