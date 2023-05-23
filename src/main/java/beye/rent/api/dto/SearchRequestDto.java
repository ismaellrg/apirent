package beye.rent.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class SearchRequestDto {
    private Long minPrice;
    private Long maxPrice;
    private String sizeAppartment;
}
