package pl.gdynia.amw.oop.lab6.calendar;

import pl.gdynia.amw.oop.lab6.calendar.events.Call;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;
import pl.gdynia.amw.oop.lab6.calendar.events.Meeting;
import pl.gdynia.amw.oop.lab6.calendar.events.Reminder;
import pl.gdynia.amw.oop.lab6.calendar.filters.*;

import java.util.ArrayList;
import java.util.List;
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

        event.getAdditionalInput(scanner);

        return event;
    }

    public List<Filter> filtersList() {
        List<Filter> filters = new ArrayList<>();
        int input = 1;
        while (input != 0) {
            System.out.println("What filter do You want to add: ");
            System.out.println("1.Filter by type of the event");
            System.out.println("2.Filter by starting hour");
            System.out.println("3.Filter by key word");
            System.out.println("4.Filter by day of event");
            System.out.println("0.That's all");
            input = scanner.nextInt();
            if (input == 1) filters.add(new TypeOfClassFilter(scanner));
            if (input == 2) filters.add(new StartingHourFilter(scanner));
            if (input == 3) filters.add(new KeyWordFilter(scanner));
            if (input == 4) filters.add(new DayFilter(scanner));
        }
        return filters;
    }

    public void show() {
        int input = 1;

        while (input != 0) {
            System.out.println("What do you want to do: ");
            System.out.println("1.Add Event");
            System.out.println("2.Delete Event");
            System.out.println("3.View events");
            System.out.println("4.View filtered");
            System.out.println("0.EXIT");
            try {
                input = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                input = 5;
                System.out.println("Provide correct input!");
            }
            if (input == 1) {
                this.calendar.addEvent(this.createEvent());
            }
            if (input == 2) {
                System.out.println("Enter the id of an event to delete: ");
                calendar.deleteEvent(scanner.nextInt());
            }
            if (input == 3) {
                calendar.showEvents();
            }
            if (input == 4) {
                calendar.showEventsFiltered(filtersList());
            }

        }

    }

}