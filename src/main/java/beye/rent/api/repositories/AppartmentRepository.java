package beye.rent.api.repositories;

import beye.rent.api.model.Appartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppartmentRepository extends JpaRepository<Appartment, Long> {
}
