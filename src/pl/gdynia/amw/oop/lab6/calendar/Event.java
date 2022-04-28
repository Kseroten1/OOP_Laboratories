package pl.gdynia.amw.oop.lab6.calendar;

import java.util.Scanner;

public interface Event {
    int getDay();

    int getHour();

    boolean getUserInput(Scanner scanner);

    void getAdditionalInput(Scanner scanner);

    int getId();
}
