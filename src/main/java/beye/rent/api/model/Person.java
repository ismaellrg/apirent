package beye.rent.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("p")
@NoArgsConstructor @AllArgsConstructor
@Data
public class Person extends Entite {
    private String firstName;
    private String lastname;

}
