package net.alfonsomadrid.swaggerexample.controller.inhabitants;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.alfonsomadrid.swaggerexample.controller.inhabitants.contract.InhabitantsControllerContract;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantRequest;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantResponse;
import net.alfonsomadrid.swaggerexample.dto.inhabitants.InhabitantUpdateRequest;
import net.alfonsomadrid.swaggerexample.service.InhabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/inhabitants")
@AllArgsConstructor
@Api
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InhabitantsController implements InhabitantsControllerContract {

    @Autowired
    InhabitantService inhabitantService;

    @GetMapping
    public Page<InhabitantResponse> getInhabitant(@ApiIgnore @NotNull Pageable pageable) { return inhabitantService.findAll(pageable); }

    @GetMapping(value="/{inhabitantId}")
    public InhabitantResponse getInhabitant(@PathVariable("inhabitantId") Long inhabitantId) {
        return inhabitantService.getInhabitant(inhabitantId);
    }

    @PostMapping
    public Long create(@Valid @RequestBody() InhabitantRequest inhabitantRequest) {
        return inhabitantService.save(inhabitantRequest);
    }

    @PutMapping(value="/{inhabitantId}")
    public InhabitantResponse update(@PathVariable("inhabitantId") Long inhabitantId, @Valid @RequestBody() InhabitantUpdateRequest inhabitantRequest) {
        return inhabitantService.update(inhabitantId, inhabitantRequest);
    }

}
