package net.alfonsomadrid.swaggerexample.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.alfonsomadrid.swaggerexample.dto.location.LocationUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.mapper.LocationMapper;
import net.alfonsomadrid.swaggerexample.model.planet.LocationEntity;
import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import net.alfonsomadrid.swaggerexample.repository.location.LocationRepository;
import net.alfonsomadrid.swaggerexample.service.exception.BadRequestException;
import net.alfonsomadrid.swaggerexample.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class LocationService {

    @Autowired
    LocationMapper locationMapper;

    @Autowired
    LocationRepository locationRepository;

    public LocationEntity findById(Long id) {
        return locationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void setLocation(PlanetEntity entity, LocationUpdateRequest request) {
        if (request != null) {
            if (request.getId() == null) {
                LocationEntity newEntity = locationMapper.mapToLocationEntity(request);
                entity.setLocation(newEntity);
            } else {
                try {
                    LocationEntity updatedEntity = findById(request.getId());
                    updatedEntity.setRegion(request.getRegion());
                    updatedEntity.setSector(request.getSector());
                    updatedEntity.setStartSystem(request.getStarSystem());
                    entity.setLocation(updatedEntity);
                } catch (NotFoundException e) {
                    throw new BadRequestException();
                }
            }
        } else {
            entity.setLocation(null);
        }
    }
}
