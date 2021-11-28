package net.alfonsomadrid.swaggerexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantResponse;
import net.alfonsomadrid.swaggerexample.dto.location.LocationResponse;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationResponse;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PlanetResponse {
    Long id;
    String name;
    String capitalCity;
    LocationResponse location;
    List<InhabitantResponse> inhabitants;
    PublicationResponse publication;
}
