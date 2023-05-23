package beye.rent.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Builder
public class Building {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Address address;

    @ManyToOne
    private Owner entite;

    /*@OneToMany
    private List<Photo> photos;*/

    public Building(String name) {
        this.name = name;
    }
}
