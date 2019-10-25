package code.class_jerarchi;

public class Cube extends Shape {
    private double a;

    public Cube(double a) {
        super(a * a * a);
        this.a = a;
    }

    public void setA(double a) {
        this.a = a;
        setVolume(a * a * a);
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * a * a;
    }
}
