package pl.gdynia.amw.oop.lab6.calendar.filters;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;

import java.util.Scanner;

public class KeyWordFilter implements Filter {
    private String keyWord;

    public KeyWordFilter(Scanner scanner) {
        this.getUserInput(scanner);
    }

    @Override
    public KeyWordFilter getUserInput(Scanner scanner) {
        keyWord = ConditionalDataProvider.get( "Provide keyWord: ",
                () -> scanner.useDelimiter("\n").next(),
                keyWord -> !keyWord.trim().isEmpty(),
                "Provide correct keyWord!"
        );
        return this;
    }

    @Override
    public boolean meetsRequirements(Event event) {
        return event.toString().toLowerCase().contains(keyWord.trim().toLowerCase());
    }
}
