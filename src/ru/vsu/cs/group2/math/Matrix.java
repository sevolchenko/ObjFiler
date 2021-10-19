package ru.vsu.cs.group2.math;

public interface Matrix {

    Matrix add(Matrix m) throws MathException;

    Matrix subtract(Matrix m) throws MathException;

    Matrix multiply(Vector v) throws MathException;

    Vector[] toVectorArray();

    Matrix transposition();

    double determinant();
}
