package ru.spstu.analytics.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;

//TODO Define this with Interface
// Migrate to builder pattern

@Getter
@AllArgsConstructor
public abstract class AbstractTask {

    private Long id;

    private String title;

    private String description;

    Parameters parameters;

}