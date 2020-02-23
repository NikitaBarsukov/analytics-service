package ru.spstu.analytics.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class UniqUsernames extends AbstractTask implements PythonScript {


    Logger logger = LoggerFactory.getLogger(UniqUsernames.class);

    public UniqUsernames() {
        super( 2L, "Unique usernames", "Get all unique usernames", new Parameters());
    }

    @Override
    public int run() throws InterruptedException, IOException {

        String folder = "C:/Users/Nikita/Desktop/edu/bin";
        String[] command = {"cmd", "%PYTHON_HOME%\\python.exe %PY_SCRIPT_DIR%show_user_way.py %DATABASE_NAME% %USER_NAME% %RESULT_DIR%08_show_user_way.csv 307144"};
        String[] command1 = {"cmd", "/c", "echo %PY_SCRIPT_DIR%"};
        String[] envp = {
                "PYTHON_HOME=..\\workdir\\installed_soft\\python",
                "PY_SCRIPT_DIR=C:\\Users\\Nikita\\Desktop\\edu\\bin\\..\\libs\\scripts\\",
                "USER_NAME=\"OPENEDU\"",
                "DATABASE_NAME=OpenEduDatabase",
                "RESULT_DIR=C:\\Users\\Nikita\\Desktop\\edu\\bin\\..\\result\\",
                "ID=307144",

        };

        logger.info("Start running");
        final Runtime r = Runtime.getRuntime();
        final Process p = r.exec(command, envp, new File(folder));
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

//    public static void main(String[] args) throws IOException, InterruptedException {
//        UniqUsernames up = new UniqUsernames();
//        up.run();
//    }

}
