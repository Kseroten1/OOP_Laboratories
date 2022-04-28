package pl.gdynia.amw.oop.lab6.calendar;

public abstract class BasicEvent implements Event {
    protected int day = 0;

    public void makeUserPromptAboutEvent() {
        System.out.println("Hey");
    }

    public int getDay() {
        return this.day;
    }
}
