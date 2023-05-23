package beye.rent.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingDto {
    private Long id;
    private String name;
    private AddressDto address;
    private OwnerDto entite;
}
