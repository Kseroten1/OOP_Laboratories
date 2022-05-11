package pl.gdynia.amw.oop;

import pl.gdynia.amw.oop.lab6.calendar.*;
import pl.gdynia.amw.oop.lab6.calendar.events.Event;
import pl.gdynia.amw.oop.lab6.calendar.events.Meeting;
import pl.gdynia.amw.oop.lab6.calendar.filters.*;
import pl.gdynia.amw.oop.lab6.calendar.menu.MenuOptionActionParameterless;
import pl.gdynia.amw.oop.lab6.calendar.menu.Menu;
import pl.gdynia.amw.oop.lab6.calendar.menu.MenuOptionAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final var calendar = new Calendar();

        final MenuOptionAction createEventAction = (chosenMenuKey) -> {
            Event event = calendar.createEvent(chosenMenuKey);
            event.getUserInput(scanner);
            event.getAdditionalInput(scanner);
            calendar.addEvent(event);
        };

        final var addEventMenu =  Menu
                .withMessage("What type of event do you want to add: ")
                .addOption("Meeting", createEventAction)
                .addOption("Reminder", createEventAction)
                .addOption("Call", createEventAction);

        final MenuOptionActionParameterless viewFilteredAction = () -> {
            List<Filter> filters = new ArrayList<>();

            final var filtersMenu = new Menu("What filter do you want to add: ");
            final Function<Filter, MenuOptionActionParameterless> addFilterAndShowMenu = (filter) -> () -> {
                filters.add(filter.getUserInput(scanner));
                filtersMenu.show();
            };

            filtersMenu.addOption("Filter by Type of event", addFilterAndShowMenu.apply(new TypeOfClassFilter()))
                    .addOption("Filter by starting hour", addFilterAndShowMenu.apply(new StartingHourFilter()))
                    .addOption("Filter by key word", addFilterAndShowMenu.apply(new KeyWordFilter()))
                    .addOption("Filter by day of event", addFilterAndShowMenu.apply(new DayFilter()))
                    .addOption("That's all", () -> calendar.showEventsFiltered(filters));

            filtersMenu.show();
        };

        final var menu = Menu
                .withMessage("What do you want to do: ")
                .addOption("Add Event", addEventMenu::show)
                .addOption("Delete Event", () -> {
                    System.out.println("Enter the id of an event to delete: ");
                    calendar.deleteEvent(scanner.nextInt());
                })
                .addOption("View events", calendar::showEvents)
                .addOption("View filtered", viewFilteredAction)
                .addOption("EXIT", MenuOptionActionParameterless.EMPTY);

        while (menu.show() != 5) {
        }
    }
}
