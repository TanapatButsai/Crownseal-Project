package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class WorkOrderDetail {

    @Id
    @GeneratedValue
    private UUID id;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder;
}
