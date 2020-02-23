package ru.spstu.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.spstu.analytics.model.LogsInfo;

import java.util.List;

@Data
@AllArgsConstructor
public class LogsInfoDto {
    List<LogsInfo> logs;
}
