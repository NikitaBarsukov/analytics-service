package ru.spstu.analytics.tasks;

    public class UniqueUserNamesAndIds extends AbstractTask implements PythonScript {

        public UniqueUserNamesAndIds() {
            super(15L, "Unique user names and ids", "", new Parameters());
            setUtility(true);
        }


        @Override
        public int run() {


            return 0;
        }
    }