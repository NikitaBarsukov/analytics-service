package ru.spstu.analytics.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;

//TODO Define this with Interface
// add JDBC

@Getter
@AllArgsConstructor
public abstract class AbstractTask {

    private String name;

    private Long id;
}