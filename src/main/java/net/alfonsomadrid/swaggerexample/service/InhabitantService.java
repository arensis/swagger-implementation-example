package net.alfonsomadrid.swaggerexample.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantRequest;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantResponse;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.mapper.InhabitantMapper;
import net.alfonsomadrid.swaggerexample.model.planet.InhabitantEntity;
import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import net.alfonsomadrid.swaggerexample.repository.inhabitant.InhabitantRepository;
import net.alfonsomadrid.swaggerexample.service.exception.BadRequestException;
import net.alfonsomadrid.swaggerexample.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class InhabitantService {

    @Autowired
    InhabitantRepository inhabitantRepository;

    @Autowired
    InhabitantMapper inhabitantMapper;

    public InhabitantResponse getInhabitant(Long id) {
        InhabitantEntity entity = findById(id);
        return inhabitantMapper.mapToInhabitantResponse(entity);
    }

    public Page<InhabitantResponse> findAll(Pageable pageable) {
        return inhabitantMapper.mapToInhabitantListResponse(inhabitantRepository.findAll(pageable));
    }

    public InhabitantEntity findById(Long id) {
        return inhabitantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Long save(InhabitantRequest request) {
        InhabitantEntity entity = inhabitantRepository.save(inhabitantMapper.mapToInhabitantEntity(request));
        return entity.getId();
    }

    public InhabitantResponse update(Long id, InhabitantUpdateRequest request) {
        InhabitantEntity entity = findById(id);
        entity.setLanguage(request.getLanguage());
        entity.setRace(request.getRace());

        InhabitantEntity updatedEntity = inhabitantRepository.save(entity);
        return inhabitantMapper.mapToInhabitantResponse(updatedEntity);
    }

    @Transactional
    public void setInhabitants(PlanetEntity entity, List<InhabitantUpdateRequest> request) {
        if (request != null) {
            List<InhabitantEntity> updateInhabitants = request.stream().map(inhabitantUpdateRequest -> {
                if (inhabitantUpdateRequest.getId() == null) {
                    InhabitantEntity newEntity = inhabitantMapper.mapToInhabitantEntity(inhabitantUpdateRequest);
                    inhabitantRepository.save(newEntity);
                    return newEntity;
                } else {
                    try {
                        InhabitantEntity updatedEntity = findById(inhabitantUpdateRequest.getId());
                        updatedEntity.setRace(inhabitantUpdateRequest.getRace());
                        updatedEntity.setLanguage(inhabitantUpdateRequest.getLanguage());
                        return updatedEntity;
                    } catch (NotFoundException e) {
                        throw new BadRequestException();
                    }
                }
            }).collect(Collectors.toList());

            entity.getInhabitants().clear();
            entity.getInhabitants().addAll(updateInhabitants);
        } else {
            entity.getInhabitants().clear();
        }
    }

}
