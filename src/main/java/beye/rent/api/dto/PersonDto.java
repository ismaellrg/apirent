package beye.rent.api.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class PersonDto extends EntiteDto{
    private String firstName;
    private String lastname;
}
