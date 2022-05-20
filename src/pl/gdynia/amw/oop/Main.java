package pl.gdynia.amw.oop;

import pl.gdynia.amw.oop.lab6.calendar.Calendar;
import pl.gdynia.amw.oop.lab6.calendar.dataproviding.ConditionalDataProvider;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;
import pl.gdynia.amw.oop.lab6.calendar.filters.*;
import pl.gdynia.amw.oop.lab6.calendar.menu.Menu;
import pl.gdynia.amw.oop.lab6.calendar.menu.MenuOptionAction;
import pl.gdynia.amw.oop.lab6.calendar.menu.MenuOptionActionParameterless;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static Path path = Path.of(System.getProperty("user.home"), "java", "calendar");
    final static File file = path.resolve("calendar.txt").toFile();

    static {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        final var calendar = new Calendar();

        calendar.load(new ObjectInputStream(new FileInputStream(file)));


        calendar.showThreeClosest();

        final MenuOptionAction createEventAction = (chosenMenuKey) -> {
            Event event = calendar.createEvent(chosenMenuKey);
            event.getUserInput(scanner);
            event.getAdditionalInput(scanner);
            calendar.addEvent(event);
        };

        final var addEventMenu = Menu
                .withMessage("What type of event do you want to add: ")
                .addOption("Meeting", createEventAction)
                .addOption("Reminder", createEventAction)
                .addOption("Call", createEventAction);

        final MenuOptionActionParameterless viewFilteredAction = () -> {
            List<Filter> filters = new ArrayList<>();

            final var filtersMenu = new Menu("What filter do you want to add: ");

            filtersMenu.addOption("Filter by Type of event", () -> {
                        filters.add(new TypeOfClassFilter(scanner));
                        filtersMenu.show();
                    })
                    .addOption("Filter by starting hour", () -> {
                        filters.add(new StartingHourFilter(scanner));
                        filtersMenu.show();
                    })
                    .addOption("Filter by key word", () -> {
                        filters.add(new KeyWordFilter(scanner));
                        filtersMenu.show();
                    })
                    .addOption("Filter by day of event", () -> {
                        filters.add(new DayFilter(scanner));
                        filtersMenu.show();
                    })
                    .addOption("That's all", () -> calendar.showEventsFiltered(filters));

            filtersMenu.show();
        };

        final var menu = Menu
                .withMessage("What do you want to do: ");
        menu.addOption("Add Event", () -> {
                    addEventMenu.show();
                    calendar.save(new ObjectOutputStream((new FileOutputStream(file))));
        });
        menu.addOption("Delete Event", () -> {
            calendar.deleteEvent(ConditionalDataProvider.get(
                    "Enter the id of an event to delete: ",
                    () -> Integer.parseInt(scanner.next()),
                    calendar::hasEvent,
                    String.format("Provide one of %s", calendar.getEventsIds())
            ));
            calendar.save(new ObjectOutputStream((new FileOutputStream(file))));
        });
        menu.addOption("View events", calendar::showEvents);
        menu.addOption("View filtered", viewFilteredAction);
        menu.addOption("EXIT", MenuOptionActionParameterless.EMPTY);

        while (menu.show() != 5) {
        }
        calendar.save(new ObjectOutputStream((new FileOutputStream(file))));
    }
}
