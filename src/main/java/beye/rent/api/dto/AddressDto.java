package beye.rent.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private Long id;
    private int num;
    private String noAppt;
    private String street;
    private String city;
    private String province;
    private String country;
    private String zipCode;
    int x;
    int y;
    int z;
    String address;
}
