package pl.gdynia.amw.oop.lab6.calendar.events;

import java.time.LocalTime;
import java.util.Scanner;

public interface Event {
    int getDay();

    LocalTime getStartOfTheEvent();

    int getId();

    String getNote();

    void getUserInput(Scanner scanner);

    void getAdditionalInput(Scanner scanner);


}
