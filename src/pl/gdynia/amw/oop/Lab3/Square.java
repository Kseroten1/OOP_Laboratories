package pl.gdynia.amw.oop.Lab3;

public class Square extends Figure {

    private Float length;

    public Square() {

    }

    @Override
    public void printSurfaceArea() {
        if (length > 0) {
            System.out.printf("Surface area of the square = %f%n", length * length);
        } else {
            System.out.println("Value of side of a Square should be a positive number");
        }
    }

    @Override
    public void printCircuit() {
        if (length > 0) {
            System.out.printf("Circuit of the square = %f%n", 4 * length);
        } else {
            System.out.println("Value of side of a Square should be a positive number");
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
