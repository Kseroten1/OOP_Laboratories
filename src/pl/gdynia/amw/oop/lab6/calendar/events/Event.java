package pl.gdynia.amw.oop.lab6.calendar.events;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Scanner;

public interface Event extends Serializable {
    int getDay();

    LocalTime getStartOfTheEvent();

    Integer getId();

    String getNote();

    void getUserInput(Scanner scanner);

    void getAdditionalInput(Scanner scanner);


}
