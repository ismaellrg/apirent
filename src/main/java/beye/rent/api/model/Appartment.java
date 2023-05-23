package beye.rent.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
public class Appartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Building building;

    @ManyToOne
    private Owner entite;

    @ManyToOne
    private Address address;

    private String size;

    @OneToMany(mappedBy = "appartment", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Photo> photos;

    private Double priceRent;

    public Appartment(Double priceRent) {
        this.priceRent = priceRent;
    }
}
