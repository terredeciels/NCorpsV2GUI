package application;

import static java.lang.Math.sqrt;

public class Vector2D {

    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2D subtract(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }

    public void multiply(double n) {
        x *= n;
        y *= n;
    }

    public double magnitude() {
        return sqrt((x * x) + (y * y));
    }

}
