package ru.spstu.analytics.tasks;

    public class UniqueUserNames extends AbstractTask implements PythonScript {

        public UniqueUserNames() {
            super(14L, "Unique user names", "", new Parameters());
            setUtility(true);
        }


        @Override
        public int run() {


            return 0;
        }
    }