package code.class_jerarchi;

abstract public class Shape implements Comparable<Shape> {
    private double volume;

    Shape(double volume)  {
        this.volume = volume;
    }

    Shape() {
        volume = 0;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    abstract public double calculateSurfaceArea();

    @Override
    public int compareTo(Shape o) {
        if (Math.abs(volume - o.volume) < 1e-6) {
            return 0;
        } else if (volume > o.volume) {
            return -1;
        } else  {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Shape{" +
                "volume=" + volume +
                '}';
    }
}
