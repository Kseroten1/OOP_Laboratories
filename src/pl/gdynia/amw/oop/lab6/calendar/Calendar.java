package pl.gdynia.amw.oop.lab6.calendar;

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

    public void showEvents(int day) {
        if (getEvents(day).isEmpty()) {
            System.out.println("There is no events in that day.");
            return;
        }
        for (var event : allDaysEvents.get(day)) {
            System.out.println(event + " ");
        }
    }

    public List<Event> getEvents(int day) {
        return allDaysEvents.getOrDefault(day, new ArrayList<>());
    }
}
