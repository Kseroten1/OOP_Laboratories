package pl.gdynia.amw.oop.lab6.calendar.events;

import java.time.LocalTime;
import java.util.Scanner;

public abstract class BasicEvent implements Event {
    protected int day;
    protected LocalTime startOfTheEvent;
    protected int id;
    protected String note;

    public BasicEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "%s#" + this.id + " Day:" + this.day + " Starting time:" + this.startOfTheEvent + " %s (" + this.note + ")";
    }

    public boolean getUserInput(Scanner scanner) {
        System.out.println("What day the event take place: ");
        this.day = scanner.nextInt();
        if (!isDayValid(day)) {
            System.out.println("INVALID DAY!!!");
            return false;
        }
        System.out.println("At what hour the event start: ");
        this.startOfTheEvent = LocalTime.of(scanner.nextInt(), 0);
        System.out.println("Note of the event: ");
        this.note = scanner.useDelimiter("\n").next();
        return true;
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

    public Boolean isDayValid(int day) {
        return day >= 1 && day <= 31;
    }
}
