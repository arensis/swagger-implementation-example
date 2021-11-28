package net.alfonsomadrid.swaggerexample.dto.inhabitants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class InhabitantRequest {
    @NotNull
    String race;
    String language;
}
