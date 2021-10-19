package ru.vsu.cs.group2.math;

public interface Vector {

    Vector add(Vector v) throws MathException;

    default Vector subtract(Vector v) throws MathException {
        return add(v.multiply(-1));
    }

    Vector multiply(double a);

    default Vector divide(double a) {
        return multiply(1 / a);
    }

    default double length() throws MathException {
        return Math.sqrt(scalarMultiply(this));
    }

    default Vector normalized() throws MathException {
        return divide(length());
    }

    double scalarMultiply(Vector v) throws MathException;

}
