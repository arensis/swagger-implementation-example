package net.alfonsomadrid.swaggerexample.model.mapper;

import lombok.AllArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantRequest;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantResponse;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.planet.InhabitantEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class InhabitantMapper {

    public Page<InhabitantResponse> mapToInhabitantListResponse(Page<InhabitantEntity> entities) {
        return entities.map(this::mapToInhabitantResponse);
    }

    public List<InhabitantResponse> mapToInhabitantListResponse(List<InhabitantEntity> entities) {
        return entities.stream().map(this::mapToInhabitantResponse).collect(Collectors.toList());
    }

    public InhabitantResponse mapToInhabitantResponse(InhabitantEntity entity) {
        return InhabitantResponse.builder()
                .id(entity.getId())
                .race(entity.getRace())
                .language(entity.getLanguage())
                .build();
    }

    public InhabitantEntity mapToInhabitantEntity(InhabitantUpdateRequest request) {
        return InhabitantEntity.builder()
                .race(request.getRace())
                .language(request.getLanguage())
                .build();
    }

    public InhabitantEntity mapToInhabitantEntity(InhabitantRequest request) {
        return InhabitantEntity.builder()
                .race(request.getRace())
                .language(request.getLanguage())
                .build();
    }
}
