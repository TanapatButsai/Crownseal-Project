package ku.cs.crownseal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue
    private UUID id;

    private String locationName;
    private String locationDetail;

    private String subDistrict;

    private String district;

    private String province;

    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "member_id") // "member_id" is the foreign key column in the PurchaseOrder table
    private Member member;
}
