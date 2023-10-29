package ku.cs.crownseal.model;

import ku.cs.crownseal.entity.Member;
import lombok.Data;

@Data
public class WorkOrderRequest {

    private String work_detail;

    private Member member;
}
