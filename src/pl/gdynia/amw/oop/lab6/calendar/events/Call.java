package pl.gdynia.amw.oop.lab6.calendar.events;

import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;

import java.util.Scanner;

public class Call extends BasicEvent {

    private String phone;

    public Call(int id) {
        super(id);
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Call", "Phone number:" + this.phone);
    }

    @Override
    public void getAdditionalInput(Scanner scanner) {
        this.phone = ConditionalDataProvider.get(
                "Number of the caller: ",
                () -> scanner.useDelimiter("\n").next(),
                phone -> phone.trim().chars().allMatch(Character::isDigit),
                "Invalid number"
        );
    }

}
