package ru.spstu.analytics.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.spstu.analytics.dto.LogsInfoDto;
import ru.spstu.analytics.dto.TaskInfoDto;
import ru.spstu.analytics.service.ExecutorService;
import ru.spstu.analytics.service.FindAllLogsService;
import ru.spstu.analytics.service.FindAllTasksService;

import javax.inject.Inject;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(
        tags = "Tasks",
        description = "Represents everything for working with our analytical ru.spstu.analytics.tasks."
)
public class TaskController {

    private final FindAllTasksService findAllTasksService;
    private final FindAllLogsService  findAllLogsService;
    private final ExecutorService     executorService;

    @Inject
    public TaskController(FindAllTasksService findAllTasksService,
                          FindAllLogsService findAllLogsService,
                          ExecutorService executorService) {
        this.findAllLogsService = findAllLogsService;
        this.findAllTasksService = findAllTasksService;
        this.executorService = executorService;
    }

    @ApiOperation(value = "Starts execute some task by its id(not implemented yet)")
    @GetMapping(value = "/execute/{taskId}/{userId}", produces = "text/html")
    public String hello(@PathVariable @NotNull @DecimalMin("0") Long taskId, @PathVariable String userId) throws IOException, InterruptedException {
//        return executorService.execute(taskId);
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Hello</title>\n" +
                "</head>\n" +
                "<body>\n" + "<text>Hello im running "+ taskId+"</text>" +
                "</body>\n" +
                "</html>";
    }


    @ApiOperation(value = "Shows all available tasks")
    @GetMapping(value = "/getAllTasks", produces = "application/json")
    public TaskInfoDto getAllTasks() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        return findAllTasksService.findAllTasks();

    }

    @ApiOperation(value = "Shows all available logs")
    @GetMapping(value = "/getAllLogs", produces = "application/json")
    public LogsInfoDto getlogsInfo() {
        return findAllLogsService.findAllLogs();
    }
}