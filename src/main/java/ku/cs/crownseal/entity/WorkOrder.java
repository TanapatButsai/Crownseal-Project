package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class WorkOrder {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "problem_id") // Foreign key column in the WorkOrder table
    private Problem problem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_report_url_id") // Foreign key column in the WorkOrder table
    private WorkReportUrl workReportUrl;

    private String work_detail;
    private LocalDateTime time_stamp_finished;
    private LocalDateTime time_stamp_start;

    @ManyToOne
    @JoinColumn(name = "member_id") // Specifies the foreign key column
    private Member member;

}