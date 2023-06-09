package beye.rent.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num;
    private String noAppartment;
    private String street;
    private String city;
    private String province;
    private String country;
    private String zipCode;
    int x;
    int y;
    int z;
    String address;

    public Address(String address) {
        this.address = address;
    }
}
