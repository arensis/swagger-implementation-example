package net.alfonsomadrid.swaggerexample.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.mapper.PublicationMapper;
import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import net.alfonsomadrid.swaggerexample.model.planet.PublicationEntity;
import net.alfonsomadrid.swaggerexample.repository.publication.PublicationRepository;
import net.alfonsomadrid.swaggerexample.service.exception.BadRequestException;
import net.alfonsomadrid.swaggerexample.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class PublicationService {

    @Autowired
    PublicationMapper publicationMapper;

    @Autowired
    PublicationRepository publicationRepository;

    public PublicationEntity findById(Long id) {
        return publicationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void setPublication(PlanetEntity entity, PublicationUpdateRequest request) {
        if (request.getId() == null) {
            PublicationEntity newEntity = publicationMapper.mapToLocationEntity(request);
            entity.setPublication(newEntity);
        } else {
            try {
                PublicationEntity updatedEntity = findById(request.getId());
                updatedEntity.setName(request.getName());
                updatedEntity.setType(request.getType());
                updatedEntity.setYear(request.getYear());
                entity.setPublication(updatedEntity);
            } catch (NotFoundException e) {
                throw new BadRequestException();
            }
        }
    }
}
