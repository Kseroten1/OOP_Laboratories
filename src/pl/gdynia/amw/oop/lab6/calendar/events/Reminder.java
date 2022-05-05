package pl.gdynia.amw.oop.lab6.calendar.events;

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
        System.out.println("Remind You about what: ");
        this.aboutWhat = scanner.useDelimiter("\n").next();
    }
}
