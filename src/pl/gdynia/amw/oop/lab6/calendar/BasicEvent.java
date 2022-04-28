package pl.gdynia.amw.oop.lab6.calendar;

import java.util.Scanner;

public abstract class BasicEvent implements Event {
    protected int day;
    protected int hour;
    protected int id;

    public BasicEvent(int id) {
        this.id = id;
    }

    public boolean getUserInput(Scanner scanner) {
        System.out.println("What day the event take place: ");
        this.day = scanner.nextInt();
        if (!isDayValid(day)) {
            System.out.println("INVALID DAY!!!");
            return false;
        }
        System.out.println("At what hour the event start: ");
        this.hour = scanner.nextInt();
        return true;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getId() {
        return this.id;
    }

    public Boolean isDayValid(int day) {
        return day >= 1 && day <= 31;
    }
}
