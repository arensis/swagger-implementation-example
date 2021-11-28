package net.alfonsomadrid.swaggerexample.controller.planets.contract;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.alfonsomadrid.swaggerexample.dto.PlanetCreationRequest;
import net.alfonsomadrid.swaggerexample.dto.PlanetResponse;
import net.alfonsomadrid.swaggerexample.dto.PlanetUpdateRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PlanetsControllerContract {
    @ApiOperation(
            value = "Gets all planets",
            tags = {"Planets"},
            nickname = "getPlanets"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Here are all the planets in the known universe"),
                    @ApiResponse(code = 404, message = "The Big Bang is starting, no planets in the horizon yet"),
                    @ApiResponse(code = 500, message = "A black hole trapped the server!")
            }
    )
    List<PlanetResponse> getPlanet();

    @ApiOperation(
            value = "Gets a planet by ID",
            tags = {"Planets"},
            nickname = "getPlanet"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Here are the planet that you have being looking for"),
                    @ApiResponse(code = 404, message = "Planet not found, maybe someone erased the planet master..."),
                    @ApiResponse(code = 500, message = "A black hole trapped the server!")
            }
    )
    PlanetResponse getPlanet(@PathVariable("planetId") Long planetId);

    @ApiOperation(
            value = "Add a new planet",
            tags = {"Planets"},
            nickname = "createPlanet"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "A new planet is included in the galaxy registry!"),
                    @ApiResponse(code = 400, message = "This astronomical object doesn't feel like a planet at all"),
                    @ApiResponse(code = 500, message = "A black hole trapped the server!")
            }
    )
    Long create(@RequestBody() PlanetCreationRequest planet);

    @ApiOperation(
            value = "Update an existing planet",
            tags = {"Planets"},
            nickname = "updatePlanet"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "New data for the planet has been added successfully"),
                    @ApiResponse(code = 400, message = "This astronomical object doesn't feel like a planet at all"),
                    @ApiResponse(code = 404, message = "Planet not found, maybe someone erased the planet master..."),
                    @ApiResponse(code = 500, message = "A black hole trapped the server!"),
            }
    )
    PlanetResponse update(@PathVariable("planetId") Long planetId, @RequestBody() PlanetUpdateRequest planet);
}
