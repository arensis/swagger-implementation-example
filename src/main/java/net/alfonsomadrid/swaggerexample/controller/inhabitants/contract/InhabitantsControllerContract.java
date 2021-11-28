package net.alfonsomadrid.swaggerexample.controller.inhabitants.contract;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.alfonsomadrid.swaggerexample.controller.annotations.ApiPageable;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantRequest;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantResponse;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

public interface InhabitantsControllerContract {
    @ApiOperation(
            value = "Gets all knowing inhabitants in the galaxy",
            tags = {"Inhabitants"},
            nickname = "getInhabitants"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Not found"),
                    @ApiResponse(code = 500, message = "Server error")
            }
    )
    @ApiPageable
    Page<InhabitantResponse> getInhabitant(@NotNull Pageable pageable);

    @ApiOperation(
            value = "Find an specific inhabitant",
            tags = {"Inhabitants"},
            nickname = "getInhabitant"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Not found"),
                    @ApiResponse(code = 500, message = "Server error")
            }
    )
    InhabitantResponse getInhabitant(@PathVariable("inhabitantId") Long inhabitantId);

    @ApiOperation(
            value = "Includes in the registry a new discovered inhabitant",
            tags = {"Inhabitants"},
            nickname = "createInhabitant"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Not found"),
                    @ApiResponse(code = 500, message = "Server error")
            }
    )
    Long create(@RequestBody() InhabitantRequest inhabitantRequest);

    @ApiOperation(
            value = "Update inhabitant",
            tags = {"Inhabitants"},
            nickname = "updateInhabitant"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Not found"),
                    @ApiResponse(code = 500, message = "Server error")
            }
    )
    InhabitantResponse update(@PathVariable("inhabitantId") Long inhabitantId, @RequestBody() InhabitantUpdateRequest inhabitantRequest);
}
