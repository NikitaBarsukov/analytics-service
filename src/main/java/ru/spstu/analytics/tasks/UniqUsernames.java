package ru.spstu.analytics.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UniqUsernames extends AbstractTask implements PythonScript {

    Logger logger = LoggerFactory.getLogger(UniqUsernames.class);

    public UniqUsernames() {
        super(2L, "Unique usernames", "Get all unique usernames", new Parameters());
    }

    @Override
    public int run() throws InterruptedException, IOException {

        String folder = "C:/Users/Nikita/Desktop/edu/bin";
        String[] command = {"cmd", "/c", "%PYTHON_HOME%\\python.exe %PY_SCRIPT_DIR%show_user_way.py %DATABASE_NAME% %USER_NAME% %RESULT_DIR%08_show_user_way.txt 307144"};

        Map<String, String> variableMap = Stream.of(new String[][]{
                {"PYTHON_HOME", "..\\workdir\\installed_soft\\python"},
                {"PY_SCRIPT_DIR", "C:\\Users\\Nikita\\Desktop\\edu\\bin\\..\\libs\\scripts\\"},
                {"USER_NAME", "\"OPENEDU\""},
                {"DATABASE_NAME", "OpenEduDatabase"},
                {"RESULT_DIR", "C:\\Users\\Nikita\\Desktop\\edu\\bin\\..\\result\\"},
                {"ID", "307144"},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        ProcessBuilder builder = new ProcessBuilder(command);
        Map<String, String> env = builder.environment();

        variableMap.forEach(env::putIfAbsent);
        builder.directory(new File(folder));
        Process p = builder.start();
        p.waitFor();

        logger.info("Start running");
        final int returnCode = p.waitFor();
        System.out.println(returnCode);

        if (logger.isWarnEnabled()) {
            final BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = is.readLine()) != null) {
                logger.warn(line);
            }
            final BufferedReader is2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = is2.readLine()) != null) {
                logger.warn(line);
            }
        }
        return 0;
    }
}