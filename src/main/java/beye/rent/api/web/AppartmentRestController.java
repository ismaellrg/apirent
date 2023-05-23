package beye.rent.api.web;

import beye.rent.api.model.Appartment;
import beye.rent.api.model.Building;
import beye.rent.api.service.AppartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppartmentRestController {

    private AppartmentService appartmentService;
    public AppartmentRestController(AppartmentService appartmentService) {
        this.appartmentService = appartmentService;
    }

    @GetMapping("/appartments")
    public List<Appartment> findAppartments() {
        return null;
        //return appartmentService.findAppartments();
    }

   @PostMapping("/appartments")
   public Appartment save(@RequestBody Appartment appartment) {
      return appartmentService.save(appartment);
   }

   @PutMapping("/appartments/{id}")
   public Appartment update(@RequestBody Appartment appartment) {
       return appartmentService.save(appartment);
   }

   @DeleteMapping("/appartments/{id}")
   public void delete() {

   }

}
