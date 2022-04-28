package pl.gdynia.amw.oop;

import pl.gdynia.amw.oop.lab6.calendar.*;

public class Main {

    public static void main(String[] args) {
        final var calendar = new Calendar();
        final var menu = new Menu(calendar);

        menu.show();
    }
}
