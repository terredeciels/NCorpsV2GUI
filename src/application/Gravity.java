package application;

import java.util.ArrayList;
import java.util.List;

import static application.Configuration.distCollision;
import static application.Configuration.mCentre;
import static application.Vector2D.subtract;
import static java.lang.Math.pow;

class Gravity {

    final List<Particule2D> allParticules_1;
    private final List<Particule2D> allParticules;
    private final double deltaT;

    Gravity(List<Particule2D> allParticules, double deltaT) {
        this.allParticules = allParticules;
        this.deltaT = deltaT;
        this.allParticules_1 = new ArrayList<>();
        allParticules.forEach(this::acc);
    }

    private void acc(Particule2D p) {

        if (p.m < mCentre) {
            for (Particule2D q : allParticules) {
                if (!p.equals(q)) {//equals ?
                    double dist = subtract(q.X, p.X).magnitude();
                    double dist3 = pow(dist, 3);
                    if (dist > distCollision) {
                        p.a.x += q.m * (q.X.x - p.X.x) / dist3;
                        p.a.y += q.m * (q.X.y - p.X.y) / dist3;
                    } else {
                        p.a.x -= q.m * (q.X.x - p.X.x) / dist3;
                        p.a.y -= q.m * (q.X.y - p.X.y) / dist3;
                    }
                }
            }
        } else {// p.m > mCentre
            for (Particule2D q : allParticules) {
                double dist = subtract(q.X, p.X).magnitude();
                if (dist < distCollision) {
                    p.m += q.m;
                }
            }
            for (Particule2D q : allParticules) {
                if (!p.equals(q)) {//equals ?
                    double dist = subtract(q.X, p.X).magnitude();
                    double dist3 = pow(dist, 3);
                    p.a.x += q.m * (q.X.x - p.X.x) / dist3;
                    p.a.y += q.m * (q.X.y - p.X.y) / dist3;
                }
            }
        }
        allParticules_1.add(p);// fusion
    }

    void move() {

        for (Particule2D p : allParticules_1) {
            double deltaT2 = pow(deltaT, 2) / 2;
            //positions
            p.X.x += deltaT2 * p.a.x + deltaT * p.v.x;
            p.X.y += deltaT2 * p.a.y + deltaT * p.v.y;
            //vitesses
            p.v.x += p.a.x;
            p.v.y += p.a.y;
        }
    }
}
