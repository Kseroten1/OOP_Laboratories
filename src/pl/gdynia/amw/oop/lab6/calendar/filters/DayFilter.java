package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public class DayFilter implements Filter {
    private Integer day;

    public DayFilter(Scanner scanner) {
        this.getUserInput(scanner);
    }

    @Override
    public DayFilter getUserInput(Scanner scanner) {
        day = ConditionalDataProvider.get( "Provide day: ",
                () -> Integer.parseInt(scanner.next()),
                day -> day > 0 && day < 31,
                "Provide correct day!"
        );
        return this;
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getDay() == day;
    }
}
