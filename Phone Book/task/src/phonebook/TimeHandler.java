package phonebook;

public class TimeHandler {

    public String handle(long begin, long end) {
        long period = end - begin;
        long minutes = period / 1000 / 60;
        long seconds = (period / 1000) % 60;
        long milliseconds = period % 1000;
        return minutes + " min. " + seconds + " sec. " + milliseconds + " ms.";

    }
}
