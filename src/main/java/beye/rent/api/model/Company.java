package beye.rent.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("c")
@NoArgsConstructor @AllArgsConstructor
@Data
public class Company  extends Entite{
    private String fiscalId;

}
