package net.alfonsomadrid.swaggerexample.dto.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LocationRequest {
    String region;
    String sector;
    String starSystem;
}
