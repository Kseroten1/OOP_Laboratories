package pl.gdynia.amw.oop.lab6.calendar.menu;

public interface MenuOptionActionParameterless {
    void invoke();

    MenuOptionActionParameterless EMPTY = () -> {
    };
}
