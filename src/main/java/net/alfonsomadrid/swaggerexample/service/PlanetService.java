package net.alfonsomadrid.swaggerexample.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.alfonsomadrid.swaggerexample.dto.PlanetCreationRequest;
import net.alfonsomadrid.swaggerexample.dto.PlanetResponse;
import net.alfonsomadrid.swaggerexample.dto.PlanetUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.mapper.PlanetMapper;
import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import net.alfonsomadrid.swaggerexample.repository.planet.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.alfonsomadrid.swaggerexample.service.exception.NotFoundException;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    PlanetMapper planetMapper;

    @Autowired
    InhabitantService inhabitantService;

    @Autowired
    PublicationService publicationService;

    @Autowired
    LocationService locationService;

    public List<PlanetResponse> findAll() {
        return planetMapper.mapToPlanetListResponse(planetRepository.findAll());
    }

    public Long save(PlanetCreationRequest request) {
        PlanetEntity entity = planetRepository.save(planetMapper.mapToPlanetEntity(request));
        return entity.getId();
    }

    public PlanetResponse findById(Long id) {
        PlanetEntity entity = planetRepository.findById(id).orElseThrow(NotFoundException::new);
        return planetMapper.mapToPlanetResponse(entity);
    }

    public PlanetResponse update(Long id, PlanetUpdateRequest request) {
        PlanetEntity entity = planetRepository.findById(id).orElseThrow(NotFoundException::new);
        entity.setName(request.getName());
        entity.setCapitalCity(request.getCapitalCity());
        locationService.setLocation(entity, request.getLocation());
        inhabitantService.setInhabitants(entity, request.getInhabitants());
        publicationService.setPublication(entity, request.getPublication());

        PlanetEntity updatedEntity = planetRepository.save(entity);

        return planetMapper.mapToPlanetResponse(updatedEntity);
    }
}
