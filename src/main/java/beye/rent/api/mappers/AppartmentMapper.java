package beye.rent.api.mappers;

import beye.rent.api.dto.*;
import beye.rent.api.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AppartmentMapper {

    public AppartmentDto fromAppartment(Appartment appartment) {
        AppartmentDto appartmentDto = AppartmentDto.builder().build();
        BeanUtils.copyProperties(appartment, appartmentDto);
        return appartmentDto;
    }

    public Appartment fromAppartmentDto(AppartmentDto appartmentDto) {
        Appartment appartment = new Appartment();
        BeanUtils.copyProperties(appartmentDto, appartment);
        if (appartmentDto.getBuilding() != null) {
            Building building = new Building();
            BeanUtils.copyProperties(appartmentDto.getBuilding(), building);
            appartment.setBuilding(building);
        }
        if (appartmentDto.getBuilding() != null) {
            Building building = new Building();
            BeanUtils.copyProperties(appartmentDto.getBuilding(), building);
            appartment.setBuilding(building);
        }
        return appartment;
    }


    public Building fromBuildingDto(BuildingDto buildingDto) {
        Building building = new Building();
        BeanUtils.copyProperties(buildingDto, building);
        return building;
    }

    public Address fromAddressDto(AddressDto addressDto) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        return address;
    }

    public Owner fromOwnerDto(OwnerDto ownerDto) {
        Owner owner = new Owner();
        BeanUtils.copyProperties(ownerDto, owner);
        return owner;
    }

    public Company fromCompanyDto(CompanyDto companyDto) {
        Company company = new Company();
        if (companyDto.getContactDto() != null) {
            company.setContact(fromContactDto(companyDto.getContactDto()));
        }
        BeanUtils.copyProperties(companyDto, company);
        return company;
    }

    public Person fromPersonDto(PersonDto personDto) {
        Person person = new Person();
        if (personDto.getContactDto() != null) {
            person.setContact(fromContactDto(personDto.getContactDto()));
        }
        BeanUtils.copyProperties(personDto, person);
        return person;
    }

    public Contact fromContactDto(ContactDto contactDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
        return contact;
    }

    public Photo fromPhotoDto(PhotoDto photoDto) {
        Photo photo = new Photo();
        BeanUtils.copyProperties(photoDto, photo );
        return photo;
    }

}
