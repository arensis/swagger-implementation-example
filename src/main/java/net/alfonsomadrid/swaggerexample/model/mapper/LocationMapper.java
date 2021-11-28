package net.alfonsomadrid.swaggerexample.model.mapper;

import lombok.AllArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.location.LocationResponse;
import net.alfonsomadrid.swaggerexample.dto.location.LocationUpdateRequest;
import net.alfonsomadrid.swaggerexample.model.planet.LocationEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LocationMapper {

    public LocationResponse mapToLocationResponse(LocationEntity entity) {
        if (entity == null) {
            return LocationResponse.builder().build();
        }
        return LocationResponse.builder()
                .id(entity.getId())
                .region(entity.getRegion())
                .sector(entity.getSector())
                .starSystem(entity.getStartSystem())
                .build();
    }

    public LocationEntity mapToLocationEntity(LocationUpdateRequest request) {
        return LocationEntity.builder()
                .region(request.getRegion())
                .sector(request.getSector())
                .startSystem(request.getStarSystem())
                .build();
    }
}
