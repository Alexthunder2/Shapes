package code.class_jerarchi;

public class Sphere extends SpinBody {
    private double radius;

    public Sphere() {
        this(0);
    }

    public Sphere(double radius) {
        super(4 * radius * radius * radius / 3 * Math.PI);
        this.radius = radius;
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * radius * radius * Math.PI;
    }
}
