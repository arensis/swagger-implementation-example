package net.alfonsomadrid.swaggerexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantUpdateRequest;
import net.alfonsomadrid.swaggerexample.dto.location.LocationUpdateRequest;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationUpdateRequest;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PlanetUpdateRequest {
    @NotNull()
    String name;
    String capitalCity;
    LocationUpdateRequest location;
    List<InhabitantUpdateRequest> inhabitants;
    @NotNull()
    PublicationUpdateRequest publication;
}
