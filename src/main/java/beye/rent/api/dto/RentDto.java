package beye.rent.api.dto;

import beye.rent.api.model.Appartment;
import beye.rent.api.model.Entite;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class RentDto {
    private Long id;
    private EntiteDto entite;
    private AppartmentDto appartment;
    private Date beginDate;
    private Date endDate;
    private Double price;
}
