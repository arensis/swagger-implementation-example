package net.alfonsomadrid.swaggerexample.controller.annotations;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface created like a workaround to fix swagger-ui documentation for Pageable documents show wrong fields
 * The issue is still opened: https://github.com/springfox/springfox/issues/2623
 *
 * Workaround link: https://github.com/springfox/springfox/issues/2623#issuecomment-471441388
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "int", paramType = "query", defaultValue = "0", value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "int", paramType = "query", defaultValue = "20", value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Example: race, Example2: race,desc "
                + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
public @interface ApiPageable {}
