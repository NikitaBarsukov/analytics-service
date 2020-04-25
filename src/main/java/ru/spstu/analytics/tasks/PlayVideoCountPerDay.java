package ru.spstu.analytics.tasks;

    public class PlayVideoCountPerDay extends AbstractTask implements PythonScript {

        public PlayVideoCountPerDay() {
            super(10L, "Show amount of video play events per day", "", new Parameters());
            setUtility(true);
        }



        @Override
        public int run() {


            return 0;
        }
    }