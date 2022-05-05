package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public class TypeOfClassFilter implements Filter {
    private final String type;

    public TypeOfClassFilter(Scanner scanner) {
        System.out.println("Provide type of event You want to search: ");
        type = scanner.next();
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getClass().getSimpleName().equalsIgnoreCase(type.trim());
    }
}
