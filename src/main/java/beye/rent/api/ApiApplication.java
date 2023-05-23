package beye.rent.api;

import beye.rent.api.mappers.AppartmentMapper;
import beye.rent.api.model.*;
import beye.rent.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AppartmentRepository appartmentRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    AppartmentMapper appartmentMapper;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.asList("name1", "name2").forEach(e->{
            personRepository.save(new Person("f-"+e, "l-"+e));
        });

        Arrays.asList("fiscal1", "fiscal2").forEach(e->{
            companyRepository.save(new Company("no-"+e));
        });

        Arrays.asList("adr1", "adr2").forEach(e->{
            addressRepository.save((new Address(e)));
        });

        List<String> builds = Arrays.asList("build1", "build2");
        builds.forEach(e -> {
            Building b = new Building(e);
            b.setAddress(addressRepository.findAll().get(0));
            buildingRepository.save(b);
        });

        Arrays.asList(920, 850).forEach(e->{
            Appartment appt = new Appartment(e.doubleValue());
            appt.setBuilding(buildingRepository.findAll().get(0));
            appartmentRepository.save(appt);
        });
///
    }
}
