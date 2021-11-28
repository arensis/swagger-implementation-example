package net.alfonsomadrid.swaggerexample.model.mapper;

import lombok.AllArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.PlanetCreationRequest;
import net.alfonsomadrid.swaggerexample.dto.PlanetResponse;
import net.alfonsomadrid.swaggerexample.model.planet.PlanetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PlanetMapper {

    @Autowired
    LocationMapper locationMapper;
    @Autowired
    InhabitantMapper inhabitantMapper;
    @Autowired
    PublicationMapper publicationMapper;

    public List<PlanetResponse> mapToPlanetListResponse(List<PlanetEntity> entities) {
        return entities.stream().map(this::mapToPlanetResponse).collect(Collectors.toList());
    }

    public PlanetResponse mapToPlanetResponse(PlanetEntity entity) {
        return PlanetResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .capitalCity(entity.getCapitalCity())
                .location(locationMapper.mapToLocationResponse(entity.getLocation()))
                .inhabitants(inhabitantMapper.mapToInhabitantListResponse(entity.getInhabitants()))
                .publication(publicationMapper.mapToPublicationResponse(entity.getPublication()))
                .build();
    }

    public PlanetEntity mapToPlanetEntity(PlanetCreationRequest request) {
        return PlanetEntity.builder()
                .name(request.getName())
                .publication(publicationMapper.mapToPublicationEntity(request.getPublication()))
                .build();
    }

}
