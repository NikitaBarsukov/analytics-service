package ru.spstu.analytics.tasks;

    public class UrlsAndNamesMapping extends AbstractTask implements PythonScript {

        public UrlsAndNamesMapping() {
            super(18L, "Calculate mapping for URLs and course section names", "", new Parameters());
            setUtility(true);
        }


        @Override
        public int run() {


            return 0;
        }
    }