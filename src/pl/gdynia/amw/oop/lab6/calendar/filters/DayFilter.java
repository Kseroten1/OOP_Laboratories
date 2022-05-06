package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public class DayFilter implements Filter {
    private final Integer day;

    public DayFilter(Scanner scanner) {
        System.out.println("Provide day: ");
        day = scanner.nextInt();
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getDay() == day;
    }
}
