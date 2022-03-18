package pl.gdynia.amw.oop.Lab3;

public class Square extends Figure {

    private int length;

    public Square() {

    }

    @Override
    public void printSurfaceArea() {
        if (length > 0) {
            System.out.printf("Surface area of the square = %d%n", length * length);
        } else {
            System.out.println("Value of side of a Square should be a positive number");
        }
    }

    @Override
    public void printCircuit() {
        if (length > 0) {
            System.out.printf("Circuit of the square = %d%n", 4 * length);
        } else {
            System.out.println("Value of side of a Square should be a positive number");
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
