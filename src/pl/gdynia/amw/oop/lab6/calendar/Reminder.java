package pl.gdynia.amw.oop.lab6.calendar;

import java.util.Scanner;

public class Reminder extends BasicEvent {
    private String aboutWhat;

    public Reminder(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Reminder : " +
                "Hour: " + hour +
                ", ID=" + id +
                ", Reminds of: '" + aboutWhat + '\'' +
                ' ';
    }

    public String getAboutWhat() {
        return aboutWhat;
    }

    @Override
    public void getAdditionalInput(Scanner scanner) {
        System.out.println("Remind You about what: ");
        this.aboutWhat = scanner.nextLine();
    }
}
