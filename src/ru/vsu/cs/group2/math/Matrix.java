package ru.vsu.cs.group2.math;

public interface Matrix {

    Vector[] getArr();

    Matrix add(Matrix m) throws MathException;

    Matrix subtract(Matrix m) throws MathException;

    Vector multiply(Vector v) throws MathException;

    Matrix multiply(double a);

    Matrix transposition();

    double determinant();
}