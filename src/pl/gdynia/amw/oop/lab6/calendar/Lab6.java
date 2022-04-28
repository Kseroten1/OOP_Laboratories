package pl.gdynia.amw.oop.lab6.calendar;

import java.util.Scanner;

public class Lab6 {
    public void run(){
        final var calendar = new Calendar();
        int input = 1;
        Scanner scanner = new Scanner(System.in);

        Event meeting = new Meeting("Moscow", 10, 8);
        Event meeting1 = new Meeting("Moscow", 10, 8);

        calendar.addEvent(meeting);
        calendar.addEvent(meeting1);
        calendar.showEvents(10);
        calendar.deleteEvent(10, 0);
        calendar.showEvents(10);



        while(input != 0) {
            System.out.println("What would you like to do: ");
            System.out.println("1.Add Event");
            System.out.println("2.Remove Event");
            System.out.println("3.Show Events");
            System.out.println("0.EXIT");
            input = scanner.nextInt();

            if(input == 1) {
                int typeOfEvent;
                System.out.println("Type of event: ");
                System.out.println("1.Meeting");
                System.out.println("2.Reminder");
                System.out.println("3.Call");
                typeOfEvent = scanner.nextInt();

            }


        }


    }
}
