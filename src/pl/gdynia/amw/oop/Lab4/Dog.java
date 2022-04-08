package pl.gdynia.amw.oop.Lab4;

public class Dog implements Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println("hau hau");
    }

    @Override
    public void printName() {
        System.out.printf("Name of an Animal is: %s%n", name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
