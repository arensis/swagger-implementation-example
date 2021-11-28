package net.alfonsomadrid.swaggerexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.alfonsomadrid.swaggerexample.dto.publication.PublicationRequest;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PlanetCreationRequest {
    @NotNull()
    String name;
    @NotNull()
    PublicationRequest publication;

}
