package pl.gdynia.amw.oop.Lab3;

public class Lab3 {

    public void run() {

        Figure figure = new Figure();
        figure.setName("First figure");

        figure.printSurfaceArea();
        figure.printCircuit();


        Triangle triangle1 = new Triangle();
        triangle1.setName("First triangle");
        triangle1.setBasis(5);
        triangle1.setHeight(12);
        triangle1.setSideB(3);
        triangle1.setSideC(6);

        triangle1.printSurfaceArea();
        triangle1.printCircuit();


        Triangle triangle2 = new Triangle();
        triangle2.setName("Not a triangle");
        triangle2.setBasis(1);
        triangle2.setSideB(2);
        triangle2.setSideC(3);

        triangle2.printSurfaceArea();
        triangle2.printCircuit();


        Square square1 = new Square();
        square1.setName("First square");
        square1.setLength(10);

        square1.printSurfaceArea();
        square1.printCircuit();


        Square square2 = new Square();
        square2.setName("Not a square");
        square2.setLength(-41);

        square2.printSurfaceArea();
        square2.printCircuit();

    }
}
