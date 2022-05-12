package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.List;
import java.util.Scanner;

public class TypeOfClassFilter implements Filter {
    private String type;

    public TypeOfClassFilter(Scanner scanner) {
        this.getUserInput(scanner);
    }

    @Override
    public TypeOfClassFilter getUserInput(Scanner scanner) {
        type = ConditionalDataProvider.get( "Provide type of event You want to search: ",
                scanner::next,
                type -> List.of("meeting", "reminder", "call").contains(type.trim().toLowerCase()),
                "Provide one of correct event types!"
        );
        return this;
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getClass().getSimpleName().equalsIgnoreCase(type.trim());
    }
}
