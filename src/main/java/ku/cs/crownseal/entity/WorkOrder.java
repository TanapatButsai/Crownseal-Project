package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class WorkOrder {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(mappedBy = "workOrder", cascade = CascadeType.ALL)
    private Problem problem;

    @ManyToOne
    @JoinColumn(name = "team_engineer_id")
    private TeamEngineer teamEngineer;

    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL)
    private List<WorkOrderDetail> workOrderDetails;
}
