package ru.vsu.cs.group2.math;

public class Vector2 implements Vector {

    public double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2 add(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector2 v2 = (Vector2) v;
        return new Vector2(x + v2.x, y + v2.y);
    }

    @Override
    public Vector2 subtract(Vector v) throws MathException {
        return add(v.multiply(-1));
    }

    @Override
    public Vector2 multiply(double a) {
        return new Vector2(x * a, y * a);
    }

    @Override
    public Vector2 divide(double a) {
        return multiply(1 / a);
    }

    @Override
    public double scalarMultiply(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector2 v2 = (Vector2) v;
        return x * v2.x + y * v2.y;
    }

    @Override
    public Vector2 normalized() throws MathException {
        return divide(length());
    }

}
