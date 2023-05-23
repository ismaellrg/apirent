package beye.rent.api;

import beye.rent.api.dto.*;
import beye.rent.api.mappers.AppartmentMapper;
import beye.rent.api.model.*;
import beye.rent.api.service.AppartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class ApiApplicationTests {
    final Long id = 1L;
    final String numAppt = "34";
    final int num = 3117;
    final String size = "3/2";
    final String street = "Sherbrooke";
    final String city = "Sherbrooke";
    final String province = "Quebec";
    final String country = "Canada";
    final String zipCode = "H2K3T6";
    final String nameBuilding = "Residence Tata";
    final String fiscalId = "Fisc1234";
    final String firstName = "firstName1";
    final String lastName = "lastName1";
    final String email1 = "email1@gm.com";
    final String tel1 = "77765444";
    final String email2 = "email2@gm.com";
    final String tel2 = "88865444";
    @Autowired
    AppartmentService appartmentService;

    @Autowired
    AppartmentMapper appartmentMapper;

    /*public ApiApplicationTests(AppartmentService appartmentService) {
        this.appartmentService = appartmentService;
    }*/

    @Test
    void fromAlloDto() {
        AlloDto alloDto = AlloDto.builder()
                .id(1L)
                .name("Allo")
                .build();
        Allo allo = new Allo();
        BeanUtils.copyProperties( alloDto, allo);
        System.out.println("Toto");
    }

    @Test
    void searchResponseDtoFromSearchRequestDto() {
        SearchRequestDto requestDto = new SearchRequestDto();
        Long priceMin = 100L;
        Long priceMax = 500L;

        requestDto.setMinPrice(priceMin);
        requestDto.setMaxPrice(priceMax);
        SearchResponseDto responseDto  = appartmentService.findAppartments(requestDto);

        responseDto.getResult().forEach(resp->
                System.out.println("id:"+resp.getId()+"-size:"+resp.getSize()));
        System.out.println("tests");
    }

    @Test
    void createCompDto() {
        ContactDto contactDto = createContactDto();
        /*CompanyDto companyDto = CompanyDto.builder()
                .build();
        companyDto.setContactDto(contactDto);*/
        System.out.println("toto");
    }

    @Test
    void mapperPhotoTest() {
        PhotoDto photoDto = PhotoDto.builder()
                .id(1L)
                .url("url1")
                .build();
        Photo photo = appartmentMapper.fromPhotoDto(photoDto);
        System.out.println("Toto");
    }

    @Test
    void mapperContactTest() {
        ContactDto contactDto =  createContactDto();
        Contact contact = appartmentMapper.fromContactDto(contactDto);
        System.out.println("Toto");
    }

    @Test
    void mapperPersonTest() {
        PersonDto personDto =  createPersonDto();
        Person person = appartmentMapper.fromPersonDto(personDto);
        System.out.println("Toto");
    }

    @Test
    void mapperCompanyTest() {
        CompanyDto companyDto =  createCompanyDto();
        Company company = appartmentMapper.fromCompanyDto(companyDto);
        System.out.println("Toto");
    }

    @Test
    void mapperAppartmentTest() {
        AppartmentDto appartmentDto =  createAppartmentDto(0,0);
        Appartment appartment = appartmentMapper.fromAppartmentDto(appartmentDto);
        System.out.println("Toto");
    }
    @Test
    void mapperListeAppartmentTest() {
        List<AppartmentDto> appartmentDtos = createAppartmentDtos();
        List<Appartment> appartment= appartmentDtos.stream()
                .map(e->appartmentMapper.fromAppartmentDto(e)).collect(Collectors.toList());
        System.out.println("Toto");
    }

    @Test
    void contextLoads() {
    }

    @Test
    void masterDataTest() {

    }

    public List<PhotoDto> createPhotoDtos() {
        AtomicLong count=new AtomicLong(0);
        List<PhotoDto> photoDtos = Stream.of("url1", "url2").map(p->
                PhotoDto.builder()
                        .id(Long.valueOf(count.incrementAndGet()))
                        .url(p)
                        .build()
        ).collect(Collectors.toList());
        return photoDtos;
    }

    public ContactDto createContactDto() {
        ContactDto contactDto = new ContactDto(tel1, email1);
        return contactDto;
    }

    public AddressDto createAddressDto(int  indexAppt, int indexNum) {
        return AddressDto.builder()
                .noAppt(numAppt+indexAppt)
                .num(num+indexNum)
                .street(street)
                .city(city)
                .province(province)
                .country(country)
                .zipCode(zipCode)
                .build();
    }

    public CompanyDto createCompanyDto() {
        ContactDto contactDto = createContactDto();
        CompanyDto companyDto = CompanyDto.builder()
        .fiscalId(fiscalId)
        .build();
        companyDto.setContactDto(contactDto);
        return companyDto;
    }

    public PersonDto createPersonDto() {
        ContactDto contactDto = createContactDto();
         PersonDto personDto = PersonDto.builder()
                .firstName(firstName)
                .lastname(lastName)
                .build();
        personDto.setContactDto(contactDto);
        return personDto;
    }

    public BuildingDto createBuildingDto() {
        CompanyDto companyDto = createCompanyDto();
        OwnerDto ownerCompanyDto = OwnerDto.builder()
                .id(id)
                .entite(companyDto)
                .build();
        return BuildingDto.builder()
                .id(id)
                .name(nameBuilding)
                .entite(ownerCompanyDto)
                .build();
    }

    public AppartmentDto createAppartmentDto(int indexAppt, int indexNum) {
        List<PhotoDto> photoDtos = createPhotoDtos();
        BuildingDto buildingDto = createBuildingDto();

        AddressDto addressDto = createAddressDto(0, 0);

        CompanyDto companyDto = createCompanyDto();
        OwnerDto ownerCompanyDto = OwnerDto.builder()
                .id(id)
                .entite(companyDto)
                .build();

        return AppartmentDto.builder()
                .id(1L)
                .size("3/2")
                .priceRent(Double.valueOf(800L))
                .photos(photoDtos)
                .building(buildingDto)
                .address(addressDto)
                .entite(ownerCompanyDto)
                .build();
    }

    public List<AppartmentDto> createAppartmentDtos() {
        AppartmentDto appartmentDto1 = createAppartmentDto(0,0);
        AppartmentDto appartmentDto2 = createAppartmentDto(1,1);
        AppartmentDto appartmentDto3 = createAppartmentDto(2,2);
        return Stream.of(appartmentDto1, appartmentDto2, appartmentDto3).collect(Collectors.toList());
    }



}
