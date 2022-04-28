package pl.gdynia.amw.oop.lab6.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    //                dzień    lista wydarzeń
    private final Map<Integer, List<Event>> events = new HashMap<>();
    
    public void addEvent(final Event event) {
        final int day = event.getDay();

        if (!this.events.containsKey(day)) {
            this.events.put(day, new ArrayList<>());
        }

        this.events.get(event.getDay()).add(event);
    }

    public void deleteEvent(int day, int index) {
        this.events.get(day).remove(index);
    }

    public void showEvents(int day) {
        for (var event:events.get(day)) {
            System.out.println(event+" ");
        }
    }

    public List<Event> getEvents(int day) {
        return events.getOrDefault(day, new ArrayList<>());
    }
}
