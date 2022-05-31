package pl.gdynia.amw.oop.lab6.calendar;

import pl.gdynia.amw.oop.lab6.calendar.events.*;
import pl.gdynia.amw.oop.lab6.calendar.filters.Filter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Calendar {
    private final Map<Integer, List<Event>> allDaysEvents = new HashMap<>();
    private Integer lastId = 0;

    public Event createEvent(int type) throws IncorrectEventTypeException {
        if (type == 1) return new Meeting(lastId++);
        if (type == 2) return new Reminder(lastId++);
        if (type == 3) return new Call(lastId++);
        throw new IncorrectEventTypeException(type);
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

    public void showThreeClosest() {
        Integer today = LocalDate.now().getDayOfMonth();
        System.out.printf("Today is: %s%n", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()));
        System.out.println("Closest Events:");

        allDaysEvents
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() >= today)
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .filter(event -> event.getDay() > today || (event.getDay() == today && event.getStartOfTheEvent().isAfter(LocalTime.now())))
                .sorted(Comparator.comparingInt(Event::getDay).thenComparing(Event::getStartOfTheEvent))
                .limit(3)
                .forEach(System.out::println);
    }

    public boolean hasEvent(int id) {
        return allDaysEvents
                .values()
                .stream()
                .flatMap(Collection::stream)
                .anyMatch(event -> event.getId() == id);
    }

    public String getEventsIds() {
        return allDaysEvents
                .values()
                .stream()
                .flatMap(Collection::stream)
                .map(Event::getId)
                .map(Object::toString)
                .collect(Collectors.joining(",  "));
    }

    public void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allDaysEvents);
    }

    @SuppressWarnings("unchecked")
    public void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allDaysEvents.putAll((Map<Integer, List<Event>>) stream.readObject());
    }
}
