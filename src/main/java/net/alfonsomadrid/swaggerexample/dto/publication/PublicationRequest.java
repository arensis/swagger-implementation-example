package net.alfonsomadrid.swaggerexample.dto.publication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.alfonsomadrid.swaggerexample.model.planet.PublicationType;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PublicationRequest {
    @NotNull()
    String name;
    @NotNull()
    PublicationType type;
    Integer year;
}
