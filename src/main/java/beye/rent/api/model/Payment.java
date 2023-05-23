package beye.rent.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;
    private Date paymentDate;
    private YearMonth rentYearMonth;

    @ManyToOne
    private Rent rent;
}
