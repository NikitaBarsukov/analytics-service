package ru.spstu.analytics.service;

import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.stereotype.Service;
import ru.spstu.analytics.tasks.AbstractTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Service
public class FindAllTasksServiceImpl implements FindAllTasksService {

    @Override
    public Map findAllTasks() throws ReflectionsException,
            IllegalAccessException, InstantiationException {
        Map<String, Long> result = new HashMap<>();
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner())
                .setUrls(ClasspathHelper.forPackage("ru.spstu.analytics.tasks")));
        Set<Class<? extends AbstractTask>> allClasses = reflections.getSubTypesOf(AbstractTask.class);
        for (Class clazz: allClasses){
            AbstractTask task = (AbstractTask) clazz.newInstance();
            result.put(task.getName(), task.getId());
        }
        return result;
    }
}