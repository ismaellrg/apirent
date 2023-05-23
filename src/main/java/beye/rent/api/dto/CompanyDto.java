package beye.rent.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class CompanyDto extends EntiteDto{
    private String fiscalId;
}
