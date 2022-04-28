package pl.gdynia.amw.oop.lab6.calendar;

public class Call extends BasicEvent {

    @Override
    public void makeUserPromptAboutEvent() {
        System.err.println("More important");
    }
}
