package pl.gdynia.amw.oop.Lab4;

public class Lab4 {

    public void run() {

        Cat cat = new Cat("Mr.Hanks");
        cat.printName();
        cat.setName("Mrs.Hanks");
        cat.printName();
        cat.voice();

        Dog dog = new Dog("Mr.Smith");
        dog.printName();
        dog.setName("Mrs.Smith");
        dog.printName();
        dog.voice();
    }
}
