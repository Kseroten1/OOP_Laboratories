package pl.gdynia.amw.oop.Lab4;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("miau miau");
    }
}
