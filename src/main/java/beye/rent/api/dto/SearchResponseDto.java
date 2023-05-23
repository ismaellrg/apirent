package beye.rent.api.dto;

import beye.rent.api.model.Appartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class SearchResponseDto {
    private List<AppartmentDto> result;
    private String err;
}
