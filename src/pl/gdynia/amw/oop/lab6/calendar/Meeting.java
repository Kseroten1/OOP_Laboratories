package pl.gdynia.amw.oop.lab6.calendar;

public class Meeting extends BasicEvent {
    private final String place;
    private final Integer hour;

    public Meeting(String place, int day, int hour) {
        this.place = place;
        this.day = day;
        this.hour = hour;
    }

    public Integer getHour() {
        return hour;
    }

    public String getPlace() {
        return place;
    }
}
