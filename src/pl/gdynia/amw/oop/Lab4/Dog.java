package pl.gdynia.amw.oop.Lab4;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("hau hau");
    }

}
