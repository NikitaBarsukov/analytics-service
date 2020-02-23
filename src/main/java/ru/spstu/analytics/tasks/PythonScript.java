package ru.spstu.analytics.tasks;

import java.io.IOException;

public interface PythonScript {
   int run() throws InterruptedException, IOException;
}
