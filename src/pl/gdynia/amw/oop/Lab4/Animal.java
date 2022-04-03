package pl.gdynia.amw.oop.Lab4;

public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void voice();

    public void printName() {
        System.out.printf("Name of an animal is: %s%n",name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
