package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.time.LocalTime;
import java.util.Scanner;

public class StartingHourFilter implements Filter {
    private final LocalTime hour;

    public StartingHourFilter(Scanner scanner) {
        System.out.println("Provide Staring hour: ");
        hour = LocalTime.of(scanner.nextInt(), 0);
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getStartOfTheEvent().equals(hour);
    }
}
