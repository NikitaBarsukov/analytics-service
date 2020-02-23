package ru.spstu.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogsInfo {
    Integer id;
    String title;
    String semester;
    Integer size;
}
