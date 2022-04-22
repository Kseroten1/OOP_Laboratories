package pl.gdynia.amw.oop.lab3;

public class Triangle extends Figure {

    private Float basis;
    private Float height;
    private Float sideB;
    private Float sideC;

    public Triangle() {

    }

    @Override
    public void printSurfaceArea() {
        if (basis > 0 && sideB > 0 && sideC > 0 && height > 0) {
            if (basis + sideB > sideC && basis + sideC > sideB && sideB + sideC > basis) {
                System.out.printf("SurfaceArea of the triangle = %f%n", height * basis / 2);
            } else {
                System.out.println("This sides can't create a triangle");
            }
        } else {
            System.out.println("Values of sides, and height should be set to a positive number");
        }
    }

    @Override
    public void printCircuit() {
        if (basis > 0 && sideB > 0 && sideC > 0) {
            if (basis + sideB > sideC && basis + sideC > sideB && sideB + sideC > basis) {
                System.out.printf("Circuit of the triangle = %f%n", basis + sideB + sideC);
            } else {
                System.out.println("This sides can't create a triangle");
            }
        } else {
            System.out.println("Values of sides must be set to a positive number");
        }
    }

    public float getBasis() {
        return basis;
    }

    public void setBasis(float basis) {
        this.basis = basis;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getSideB() {
        return sideB;
    }

    public void setSideB(float sideB) {
        this.sideB = sideB;
    }

    public float getSideC() {
        return sideC;
    }

    public void setSideC(float sideC) {
        this.sideC = sideC;
    }
}
