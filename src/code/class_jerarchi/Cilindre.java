package code.class_jerarchi;

public class Cilindre extends SpinBody {
    private double radius;
    private double height;

    public Cilindre(double radius, double height) {
        super(Math.PI * radius * radius * height);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (height + radius);
    }
}
