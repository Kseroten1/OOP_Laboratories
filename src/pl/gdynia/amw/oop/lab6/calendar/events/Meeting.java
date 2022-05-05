package pl.gdynia.amw.oop.lab6.calendar.events;

import java.util.Scanner;

public class Meeting extends BasicEvent {
    private String place;

    public Meeting(int id) {
        super(id);
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
