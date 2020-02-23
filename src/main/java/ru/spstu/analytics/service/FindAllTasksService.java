package ru.spstu.analytics.service;

import ru.spstu.analytics.dto.TaskInfoDto;

public interface FindAllTasksService {

    TaskInfoDto findAllTasks() throws IllegalAccessException, InstantiationException, ClassNotFoundException;

}