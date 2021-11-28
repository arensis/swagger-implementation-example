package net.alfonsomadrid.swaggerexample.dto.publication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.alfonsomadrid.swaggerexample.model.planet.PublicationType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PublicationResponse {
    Long id;
    String name;
    PublicationType type;
    Integer year;
}
