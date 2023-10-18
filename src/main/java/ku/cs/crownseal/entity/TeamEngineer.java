package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class TeamEngineer {

    @Id
    @GeneratedValue
    private UUID id;

    private String teamName;


    @OneToMany(mappedBy = "teamEngineer", cascade = CascadeType.ALL)
    private List<WorkOrder> workOrders;
}
