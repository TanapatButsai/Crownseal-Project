package ku.cs.crownseal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class WorkReportUrl {
    @Id
    @GeneratedValue
    private UUID id;

    private String workOrderDetailUrl;
    private String repairingReportUrl;
}
