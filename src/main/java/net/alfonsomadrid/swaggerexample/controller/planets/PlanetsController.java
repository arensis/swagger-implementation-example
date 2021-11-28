package net.alfonsomadrid.swaggerexample.controller.planets;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.alfonsomadrid.swaggerexample.controller.planets.contract.PlanetsControllerContract;
import net.alfonsomadrid.swaggerexample.dto.PlanetCreationRequest;
import net.alfonsomadrid.swaggerexample.dto.PlanetResponse;
import net.alfonsomadrid.swaggerexample.dto.PlanetUpdateRequest;
import net.alfonsomadrid.swaggerexample.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planets")
@AllArgsConstructor
@Api
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlanetsController implements PlanetsControllerContract {

    @Autowired
    PlanetService planetService;

    @GetMapping
    public List<PlanetResponse> getPlanet() {
        return planetService.findAll();
    }

    @GetMapping(value="/{planetId}")
    public PlanetResponse getPlanet(@PathVariable("planetId") Long planetId) {
        return planetService.findById(planetId);
    }

    @PostMapping
    public Long create(@Valid @RequestBody() PlanetCreationRequest planet) {
        return planetService.save(planet);
    }

    @PutMapping(value="/{planetId}")
    public PlanetResponse update(@PathVariable("planetId") Long planetId, @Valid @RequestBody() PlanetUpdateRequest planet) {
        return planetService.update(planetId, planet);
    }
}
