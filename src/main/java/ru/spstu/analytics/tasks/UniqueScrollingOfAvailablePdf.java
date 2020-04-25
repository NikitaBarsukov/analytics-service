package ru.spstu.analytics.tasks;

    public class UniqueScrollingOfAvailablePdf extends AbstractTask implements PythonScript {

        public UniqueScrollingOfAvailablePdf() {
            super(13L, "Show amount of unique scrolling pdf", "", new Parameters());
            setUtility(true);
        }


        @Override
        public int run() {


            return 0;
        }
    }