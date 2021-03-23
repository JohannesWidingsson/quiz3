package quiz;

import java.time.*;

public class Time extends Thread {

    public Time(String str) {

        super(str);
    }

    @Override
    public void run() {

        LocalTime start = LocalTime.now(); // Option one


        System.out.println(start);

        Instant instant = Instant.now(); // Option two
        System.out.println(instant);
        LocalTime end = LocalTime.now();
        Duration dur = Duration.between(start, end);
        System.out.println(dur.getNano() + " Nano Seconds between Start and End");

        System.out.println("This code is running in a thread");
    }

}
