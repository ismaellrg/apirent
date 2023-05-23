package beye.rent.api.service;

import beye.rent.api.dto.AppartmentDto;
import beye.rent.api.dto.SearchRequestDto;
import beye.rent.api.dto.SearchResponseDto;
import beye.rent.api.mappers.AppartmentMapper;
import beye.rent.api.model.Appartment;
import beye.rent.api.model.Building;
import beye.rent.api.repositories.AppartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppartmentService {

    private AppartmentRepository appartmentRepository;
    private AppartmentMapper appartmentMapper;

    public AppartmentService(AppartmentRepository appartmentRepository, AppartmentMapper appartmentMapper) {
        this.appartmentRepository = appartmentRepository;
        this.appartmentMapper = appartmentMapper;
    }

    public SearchResponseDto findAppartments(SearchRequestDto requestDto) {
        List<Appartment> appartments = appartmentRepository.findAll();
        List<AppartmentDto> appartmentDtos= appartments.stream()
                .map(e->appartmentMapper.fromAppartment(e)).collect(Collectors.toList());

        return SearchResponseDto.builder()
                .result(appartmentDtos)
                .build();
    }

    public Appartment save(Appartment appartment) {
        return appartmentRepository.save(appartment);
    }

    public Appartment update(Long id, Appartment appartment) {
        Appartment appartmentBd = appartmentRepository.findById(id).orElseThrow();
        if (appartment.getSize()!=null) appartmentBd.setSize(appartment.getSize());
        return appartmentRepository.save(appartmentBd);
    }

}
