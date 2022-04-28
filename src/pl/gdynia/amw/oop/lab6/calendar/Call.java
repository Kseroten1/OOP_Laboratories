package pl.gdynia.amw.oop.lab6.calendar;

import java.util.Scanner;

public class Call extends BasicEvent {

    private String phone;

    public Call(int id) {
        super(id);
    }

    public String getNumber() {
        return phone;
    }

    @Override
    public String toString() {
        return "Call: " +
                "Hour: " + hour +
                ", ID=" + id +
                ", Phone: '" + phone + '\'' +
                ' ';
    }

    @Override
    public void getAdditionalInput(Scanner scanner) {
        System.out.println("The number of caller: ");
        this.phone = scanner.nextLine();
    }

}
