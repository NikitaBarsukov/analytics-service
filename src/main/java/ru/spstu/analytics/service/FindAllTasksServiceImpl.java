package ru.spstu.analytics.service;

import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.stereotype.Service;
import ru.spstu.analytics.dto.TaskInfoDto;
import ru.spstu.analytics.tasks.AbstractTask;

import java.util.*;


@Service
public class FindAllTasksServiceImpl implements FindAllTasksService {

    @Override
    public TaskInfoDto findAllTasks() throws ReflectionsException,
            IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner())
                .setUrls(ClasspathHelper.forPackage("ru.spstu.analytics.tasks")));
        Set<Class<? extends AbstractTask>> allClasses = reflections.getSubTypesOf(AbstractTask.class);
        List<AbstractTask> taskList = new ArrayList<AbstractTask>();
        for (Class clazz: allClasses){
            AbstractTask task = (AbstractTask) clazz.newInstance();
            taskList.add(task);
        }
        return new TaskInfoDto(taskList);
    }
}