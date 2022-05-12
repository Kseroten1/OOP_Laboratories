package pl.gdynia.amw.oop.lab6.calendar.events;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;

import java.util.Scanner;

public class Reminder extends BasicEvent {
    private String aboutWhat;

    public Reminder(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Reminder", "Remind about what:" + this.aboutWhat);
    }

    public String getAboutWhat() {
        return aboutWhat;
    }

    @Override
    public void getAdditionalInput(Scanner scanner) {
        ConditionalDataProvider<String> aboutWhatProvider = new ConditionalDataProvider<>(
                "Remind You of what: ",
                () -> scanner.useDelimiter("\n").next(),
                aboutWhat -> aboutWhat.trim().isEmpty(),
                "Invalid reminder message"
        );
        this.aboutWhat = aboutWhatProvider.provide();
    }
}
