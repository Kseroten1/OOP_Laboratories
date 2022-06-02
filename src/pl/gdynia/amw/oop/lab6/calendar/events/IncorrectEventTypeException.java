package pl.gdynia.amw.oop.lab6.calendar.events;

public class IncorrectEventTypeException extends Throwable {
    public IncorrectEventTypeException(Integer valueGiven) {
        super(String.format("Expected type in range [1,3] given: %d", valueGiven));
    }
}
