package ru.spstu.analytics.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spstu.analytics.dto.LogsInfoDto;
import ru.spstu.analytics.service.FindAllLogsService;
import ru.spstu.analytics.service.FindAllTasksService;

import javax.inject.Inject;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@Api(
        tags = "Tasks",
        description = "Represents everything for working with our analytical ru.spstu.analytics.tasks."
)
public class TaskController {

    private final FindAllTasksService findAllTasksService;
    private final FindAllLogsService findAllLogsService;

    @Inject
    public TaskController(FindAllTasksService findAllTasksService, FindAllLogsService findAllLogsService) {
        this.findAllLogsService = findAllLogsService;
        this.findAllTasksService = findAllTasksService;
    }

    //TODO add task id parameter
    @ApiOperation(value = "Starts execute some task by its id(not implemented yet)")
    @GetMapping("/execute/{taskId}")
    public String hello(@PathVariable @NotNull @DecimalMin("0") Long taskId){
        return "I am running " + taskId;
    }


    @ApiOperation(value = "Shows all available tasks")
    @GetMapping("/getAllTasks")
    public String getAllTasks() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
        return new ObjectMapper().writeValueAsString(
                findAllTasksService.findAllTasks()
        );
    }

    @ApiOperation(value = "Shows all available logs")
    @GetMapping("/getAllLogs")
    public LogsInfoDto getlogsInfo(){
        return findAllLogsService.findAllLogs();
    }
}