package pl.gdynia.amw.oop.Lab4;

public class Cat implements Animal {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void voice() {
        System.out.println("miau miau");
    }

    @Override
    public void printName() {
        System.out.printf("Name of an Animal is: %s%n", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
