package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public class KeyWordFilter implements Filter {
    private final String keyWord;

    public KeyWordFilter(Scanner scanner) {
        System.out.println("Provide keyword: ");
        keyWord = scanner.next();
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.toString().toLowerCase().contains(keyWord.trim().toLowerCase());
    }
}
