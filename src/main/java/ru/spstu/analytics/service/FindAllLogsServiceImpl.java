package ru.spstu.analytics.service;

import org.springframework.stereotype.Service;
import ru.spstu.analytics.dto.LogsInfoDto;
import ru.spstu.analytics.model.LogsInfo;

import java.util.Arrays;
import java.util.List;

@Service
public class FindAllLogsServiceImpl implements FindAllLogsService {
    @Override
    public LogsInfoDto findAllLogs() {
        return new LogsInfoDto(Arrays.asList(
                new LogsInfo(
                        1,
                        "Philosophy logs",
                        "autumn 2018",
                        18000
                ),
                new LogsInfo(
                        2,
                        "Big Data course",
                        "spring 2019",
                        23435
                )
            )
        );
    }
}