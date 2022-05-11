package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.time.LocalTime;
import java.util.Scanner;

public class StartingHourFilter implements Filter {
    private LocalTime hour;

    @Override
    public StartingHourFilter getUserInput(Scanner scanner) {
        System.out.println("Provide type of event You want to search: ");
        hour = LocalTime.of(scanner.nextInt(), 0);
        return this;
    }
    @Override
    public boolean meetsRequirements(Event event) {
        return event.getStartOfTheEvent().equals(hour);
    }
}
