package pl.gdynia.amw.oop.lab6.calendar.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface MenuOptionActionParameterless {
    void invoke() throws IOException;

    MenuOptionActionParameterless EMPTY = () -> {
    };
}
