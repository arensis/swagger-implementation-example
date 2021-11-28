package net.alfonsomadrid.swaggerexample.model.mapper;

import lombok.AllArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationRequest;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationResponse;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.planet.PublicationEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PublicationMapper {

    public PublicationEntity mapToPublicationEntity(PublicationRequest request) {
        return PublicationEntity.builder()
                .name(request.getName())
                .type(request.getType())
                .year(request.getYear())
                .build();
    }

    public PublicationResponse mapToPublicationResponse(PublicationEntity entity) {
        return PublicationResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .build();
    }

    public PublicationEntity mapToLocationEntity(PublicationUpdateRequest request) {
        return PublicationEntity.builder()
                .name(request.getName())
                .type(request.getType())
                .year(request.getYear())
                .build();
    }
}
