package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.time.LocalTime;
import java.util.Scanner;

public class StartingHourFilter implements Filter {
    private LocalTime hour;

    public StartingHourFilter(Scanner scanner) {
        this.getUserInput(scanner);
    }

    @Override
    public StartingHourFilter getUserInput(Scanner scanner) {
        hour = LocalTime.of(ConditionalDataProvider.get( "Provide hour: ",
                () -> Integer.parseInt(scanner.next()),
                hour -> hour > 0 && hour < 31,
                "Provide correct day!"
        ), 0);
        return this;
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.getStartOfTheEvent().equals(hour);
    }
}
