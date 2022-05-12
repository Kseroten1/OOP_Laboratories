package pl.gdynia.amw.oop.lab6.calendar.events;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;

import java.time.LocalTime;
import java.util.Scanner;

public abstract class BasicEvent implements Event {
    protected Integer day;
    protected LocalTime startOfTheEvent;
    protected Integer id;
    protected String note;

    public BasicEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "%s#" + this.id + " Day:" + this.day + " Starting time:" + this.startOfTheEvent + " %s (" + this.note + ")";
    }

    public void getUserInput(Scanner scanner) {
        ConditionalDataProvider<Integer> dayProvider = new ConditionalDataProvider<>(
                "What day the event take place:",
                () -> Integer.parseInt(scanner.next()),
                day -> day > 0 && day <= 31,
                "Invalid day"
        );
        this.day = dayProvider.provide();

        ConditionalDataProvider<Integer> hourProvider = new ConditionalDataProvider<>(
                "At what hour the event start: ",
                () -> Integer.parseInt(scanner.next()),
                hour -> hour >= 0 && hour <= 24,
                "Invalid hour"
        );
        this.startOfTheEvent = LocalTime.of(hourProvider.provide(), 0);

        ConditionalDataProvider<String> noteProvider = new ConditionalDataProvider<>(
                "Note of the event: ",
                () -> scanner.useDelimiter("\n").next(),
                note -> !note.trim().isEmpty(),
                "Note cannot be empty"
        );
        this.note = noteProvider.provide();
    }

    public int getDay() {
        return this.day;
    }

    public LocalTime getStartOfTheEvent() {
        return this.startOfTheEvent;
    }

    public int getId() {
        return this.id;
    }

    public String getNote() {
        return this.note;
    }
}
