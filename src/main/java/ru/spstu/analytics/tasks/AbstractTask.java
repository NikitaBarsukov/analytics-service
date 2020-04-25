package ru.spstu.analytics.tasks;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor // only for @NotNull or final vars
public abstract class AbstractTask {

    final private Long id;

    final private String title;

    final private String description;

    final Parameters parameters;

    @Getter
    @Setter
    public boolean isUtility = false;

    public boolean isNotUtility(){
        return !isUtility();
    }
}