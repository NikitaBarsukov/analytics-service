package ru.spstu.analytics.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(
        tags = "Tasks",
        description = "Represents everything for working with our analytical tasks."
)
public class QueryController {

    //TODO add task id parameter
    @ApiOperation(value = "Starts execute some task by its id(not implemented yet)")
    @GetMapping("/execute")
    public String hello(){
        return "Not implemented yet, guys =(";
    }
}
//TODO create a controller that handles GET to get all available tasks for execute