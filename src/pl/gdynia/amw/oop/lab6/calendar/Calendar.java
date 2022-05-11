package pl.gdynia.amw.oop.lab6.calendar;

import pl.gdynia.amw.oop.lab6.calendar.events.Call;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;
import pl.gdynia.amw.oop.lab6.calendar.events.Meeting;
import pl.gdynia.amw.oop.lab6.calendar.events.Reminder;
import pl.gdynia.amw.oop.lab6.calendar.filters.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calendar {
    private final Map<Integer, List<Event>> allDaysEvents = new HashMap<>();
    private Integer lastId = 0;

    public Event createEvent(int type) {
        if (type == 1) return new Meeting(lastId++);
        if (type == 2) return new Reminder(lastId++);
        if (type == 3) return new Call(lastId++);
        throw new Error("Incorrect event type");
    }

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

    public void showEventsFiltered(List<Filter> filters) {
        final var filtered = allDaysEvents
                .values()
                .stream()
                .flatMap(List::stream)
                .filter(event -> filters.stream().allMatch(filter -> filter.meetsRequirements(event)))
                .collect(Collectors.toList());

        if (filtered.size() > 0) {
            filtered.forEach(System.out::println);
        } else {
            System.out.println("No matching results");
        }
    }
}
