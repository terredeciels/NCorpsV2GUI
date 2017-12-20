package application;

import javafx.scene.layout.Region;

public class Particule2D extends Region {

    public final Vector2D v;
    public final Vector2D a;
    public final Vector2D X;
    public double m;

    public Particule2D(double masse, Vector2D position, Vector2D velocity,
                       Vector2D acceleration) {
        m = masse;
        v = velocity;
        a = acceleration;
        X = position;
    }

}