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

    private LocalDateTime timestamp;
    private String location;
    private String status;



    @ManyToOne
    @JoinColumn(name = "member_id") // "member_id" is the foreign key column in the PurchaseOrder table
    private Member member;

    @OneToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder;
}
