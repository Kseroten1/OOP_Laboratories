package pl.gdynia.amw.oop.lab6.calendar.menu;

import pl.gdynia.amw.oop.lab6.calendar.events.IncorrectEventTypeException;

public interface MenuOptionAction {
    void invokeAction(Integer chosenMenuKey) throws IncorrectEventTypeException;
}
