package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

public interface Filter {
    boolean meetsRequirements(Event event);
}
