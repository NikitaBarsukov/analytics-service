package ru.spstu.analytics.tasks;

    public class UniqueEventNames extends AbstractTask implements PythonScript {

        public UniqueEventNames() {
            super(12L, "Unique event names", "", new Parameters());
            setUtility(true);
        }


        @Override
        public int run() {


            return 0;
        }
    }