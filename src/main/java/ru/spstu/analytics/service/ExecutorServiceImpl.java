package ru.spstu.analytics.service;

import org.springframework.stereotype.Service;
import ru.spstu.analytics.tasks.UniqUsernames;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//hardcoded for demo; need to create map with id->Abstract obj and choose from them

@Service
public class ExecutorServiceImpl implements ExecutorService {
    @Override
    public String execute(Long taskId) throws IOException, InterruptedException {
        Stream<String> lines = Files.lines(Paths.get("C:/Users/Nikita/Documents/work/analytics-service/src/main/generated_pages/userway.html"));
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
//        UniqUsernames up = new UniqUsernames();
//        up.run();
        return data;
    }
}
