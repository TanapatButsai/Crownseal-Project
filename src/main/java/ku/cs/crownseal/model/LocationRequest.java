package ku.cs.crownseal.model;

import lombok.Data;

@Data
public class LocationRequest {

    private String locationName;

    private String locationDetail;

    private String subDistrict;

    private String district;

    private String province;

    private String postalCode;
}
