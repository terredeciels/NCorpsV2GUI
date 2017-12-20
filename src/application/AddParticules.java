package application;

import javafx.animation.AnimationTimer;

import java.util.List;
import java.util.Random;

import static application.Constants.H;
import static application.Constants.W;
import static java.lang.Math.*;

abstract class AddParticules extends AnimationTimer {

    private final Random random = new Random();
    List<Particule2D> allParticles;
    private int index;

    void addParticule() {

        double r = Configuration.RCouronne + random.nextDouble() * Configuration.epCouronne;
        double theta = random.nextDouble() * 2 * PI;

        double x = W / 2 + r * cos(theta);
        double y = H / 2 + r * sin(theta);
        Vector2D X = new Vector2D(x, y);

        Vector2D v;
        if (index < Configuration.NbParticules / 2) {
            v = new Vector2D(-sin(theta), cos(theta));
            v.multiply(Configuration.multiplyVitPos);
        } else {
            v = new Vector2D(sin(theta), -cos(theta));
            v.multiply(Configuration.multiplyVitNeg);
        }
        index++;
        Vector2D a = new Vector2D(0, 0);
        Particule2D particle = new Particule2D(Configuration.mPart, X, v, a);

        allParticles.add(particle);

    }

    void addParticule_0() {
        double x = W / 2;
        double y = H / 2;
        Vector2D X = new Vector2D(x, y);
        Vector2D v = new Vector2D(0, 0);
        Vector2D a = new Vector2D(0, 0);
        Particule2D p = new Particule2D(Configuration.mCentre, X, v, a);
        allParticles.add(p);
    }

}
