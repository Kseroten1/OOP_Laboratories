package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public class DayFilter implements Filter {
    private Integer day;

    @Override
    public DayFilter getUserInput(Scanner scanner) {
        System.out.println("Provide day: ");
        day = scanner.nextInt();
        return this;
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getDay() == day;
    }
}
