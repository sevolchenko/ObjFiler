package ru.vsu.cs.group2.math;

public interface Vector {

    Vector add(Vector v) throws MathException;

    Vector subtract(Vector v) throws MathException;

    Vector multiply(double a);

    default Vector divide(double a) {
        return multiply(1 / a);
    }

    default double length() throws MathException {
        return Math.sqrt(scalarMultiply(this));
    }

    Vector normalized() throws MathException;


    double scalarMultiply(Vector v) throws MathException;

}
