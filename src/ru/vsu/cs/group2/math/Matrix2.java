package ru.vsu.cs.group2.math;

public class Matrix2 implements Matrix {

    public Matrix2(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix2(Vector2 v1, Vector2 v2) {
        matrix = new double[][]{{v1.x, v2.y}, {v2.x, v2.y}};
    }

    public double[][] matrix;

    @Override
    public Matrix2 add(Matrix m) throws MathException {
        if (m.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Matrix2 m2 = (Matrix2) m;
        Vector2[] v = toVectorArray();
        Vector2[] v2 = m2.toVectorArray();
        return new Matrix2(v[0].add(v2[0]), v[1].add(v2[1]));
    }

    @Override
    public Matrix subtract(Matrix m) throws MathException {
        if (m.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Matrix2 m2 = (Matrix2) m;
        Vector2[] v = toVectorArray();
        Vector2[] v2 = m2.toVectorArray();
        return new Matrix2(v[0].subtract(v2[0]), v[1].subtract(v2[1]));
    }

    @Override
    public Matrix multiply(Vector v) throws MathException {
        return null;
    }

    @Override
    public Vector2[] toVectorArray() {
        return new Vector2[0];
    }

    @Override
    public Matrix transposition() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }
}
