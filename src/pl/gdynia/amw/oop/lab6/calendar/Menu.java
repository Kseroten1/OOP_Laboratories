package pl.gdynia.amw.oop.lab6.calendar;

import java.util.Scanner;

public class Menu {

    private final Calendar calendar;

    public Menu(Calendar calendar) {
        this.calendar = calendar;
    }

    static Scanner scanner = new Scanner(System.in);
    static int lastId = 0;

    public Event typeOfEvent(int type) {
        if (type == 1) return new Meeting(lastId++);
        if (type == 2) return new Reminder(lastId++);
        if (type == 3) return new Call(lastId++);
        throw new Error("Incorrect event type");
    }

    public Event createEvent() {
        System.out.println("What type of event do you want to add: ");
        System.out.println("1.Meeting");
        System.out.println("2.Reminder");
        System.out.println("3.Call");
        int type = scanner.nextInt();

        Event event = typeOfEvent(type);

        if (!event.getUserInput(scanner)) {
            return null;
        }

        scanner.nextLine();
        event.getAdditionalInput(scanner);


        return event;
    }

    public void show() {
        int input = 1;

        while (input != 0) {
            System.out.println("What do you want to do: ");
            System.out.println("1.Add Event");
            System.out.println("2.Delete Event");
            System.out.println("3.View events");
            System.out.println("0.EXIT");
            input = scanner.nextInt();
            if (input == 1) {
                this.calendar.addEvent(this.createEvent());
            }
            if (input == 2) {
                System.out.println("Enter the id of an event to delete: ");
                calendar.deleteEvent(scanner.nextInt());
            }
            if (input == 3) {
                System.out.println("What day do You want to view: ");
                calendar.showEvents(scanner.nextInt());
            }

        }

    }

}