package ru.spstu.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.spstu.analytics.tasks.AbstractTask;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskInfoDto {
    List<AbstractTask> tasks;
}
