package pl.gdynia.amw.oop.lab6.calendar.events;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;

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
        ConditionalDataProvider<String> placeProvider = new ConditionalDataProvider<>(
                "What place will the meeting take place: ",
                () -> scanner.useDelimiter("\n").next(),
                place -> Character.isUpperCase(place.charAt(0)),
                "Invalid place"
        );
        this.place = placeProvider.provide();
    }
}
