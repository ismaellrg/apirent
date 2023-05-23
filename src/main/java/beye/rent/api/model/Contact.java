package beye.rent.api.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contact {
    private String tel;
    private String email;
}
