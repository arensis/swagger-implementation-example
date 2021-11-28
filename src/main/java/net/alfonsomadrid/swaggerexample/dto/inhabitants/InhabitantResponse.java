package net.alfonsomadrid.swaggerexample.dto.inhabitants;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class InhabitantResponse {
    @ApiModelProperty(position = 1)
    Long id;
    @ApiModelProperty(position = 2)
    String race;
    @ApiModelProperty(position = 3)
    String language;
}
