package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public interface Filter {
    boolean meetsRequirements(Event event);

    Filter getUserInput(Scanner scanner);
}
