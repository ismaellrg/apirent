package beye.rent.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppartmentDto {
    private Long id;
    private BuildingDto building;
    private OwnerDto entite;
    private AddressDto address;
    private String size;
    private List<PhotoDto> photos;
    private Double priceRent;
}
