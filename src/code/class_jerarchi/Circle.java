package code.class_jerarchi;

import code.annotations.ConvertableTo;

@ConvertableTo(value = {Sphere.class, Cilindre.class, Cube.class})
public class Circle extends TwoDimensionalShape {
    private double a;

    public Circle(double a) {
        super(a * a);
        this.a = a;
    }

    @Override
    public double calculateSurfaceArea() {
        return 0;
    }

    public double getA() {
        return a;
    }
}
