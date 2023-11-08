package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String name;
    private String role;
    private String email;
    private String phoneNumber;

    private String locationName;
    private String locationDetail;
    private String district;
    private String province;
    private String postalCode;

    @OneToMany(mappedBy = "member") //
    private List<Problem> ProblemList = new ArrayList<>();

    public int getWorkOrderListCount() {
        int count = 0;
        for (WorkOrder workOrder : workOrderList) {
            if (workOrder.getProblem().getStatus().equals("กำลังดำเนินการ")) {
                count++;
            }
        }
        return count;
    }

    @OneToMany(mappedBy = "member") // Defines the relationship
    private List<WorkOrder> workOrderList =  new ArrayList<>();


}
