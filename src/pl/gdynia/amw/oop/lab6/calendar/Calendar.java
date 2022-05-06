package pl.gdynia.amw.oop.lab6.calendar;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;
import pl.gdynia.amw.oop.lab6.calendar.filters.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    //                dzień    lista wydarzeń
    private final Map<Integer, List<Event>> allDaysEvents = new HashMap<>();

    public void addEvent(final Event event) {
        if (event == null) {
            return;
        }
        final int day = event.getDay();

        if (!this.allDaysEvents.containsKey(day)) {
            this.allDaysEvents.put(day, new ArrayList<>());
        }

        this.allDaysEvents.get(event.getDay()).add(event);
    }

    public void deleteEvent(int id) {
        this.allDaysEvents.forEach((day, eventsInThatDay) -> eventsInThatDay.removeIf(event -> event.getId() == id));
    }

    public void showEvents() {
        allDaysEvents
                .values()
                .stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

// line 53
//    private boolean meetsRequirementsMultiple(Event event, List<Filter> filters) {
//        for (var filter : filters) {
//            if (!filter.meetsRequirements(event)) return false;
//        }
//        return true;
//        }

    public void showEventsFiltered(List<Filter> filters) {
        allDaysEvents
                .values()
                .stream()
                .flatMap(List::stream)
                .filter(event -> filters.stream().allMatch(filter -> filter.meetsRequirements(event)))
                .forEach(System.out::println);
    }
}
