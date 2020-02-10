package ru.spstu.analytics.service;

import java.util.Map;

public interface FindAllTasksService {

    Map findAllTasks() throws IllegalAccessException, InstantiationException, ClassNotFoundException;

}