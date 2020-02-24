package ru.spstu.analytics.service;

import java.io.IOException;

public interface ExecutorService {

    String execute(Long taskId) throws IOException, InterruptedException;
}
