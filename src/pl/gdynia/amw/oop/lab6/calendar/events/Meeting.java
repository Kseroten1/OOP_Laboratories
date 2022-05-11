package pl.gdynia.amw.oop.lab6.calendar.events;

import java.time.LocalTime;
import java.util.Scanner;

public class Meeting extends BasicEvent {
    private String place;

    public Meeting(int id) {
        super(id);
    }

    public Meeting(int id, String place, Integer day, LocalTime startOfTheEvent, String note) {
        super(id);
        this.place = place;
        this.day = day;
        this.startOfTheEvent = startOfTheEvent;
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Meeting", "Place:" + this.place);
    }

    public String getPlace() {
        return place;
    }

    @Override
    public void getAdditionalInput(Scanner scanner) {
        System.out.println("At what place the meeting take place: ");
        this.place = scanner.useDelimiter("\n").next();
    }
}
