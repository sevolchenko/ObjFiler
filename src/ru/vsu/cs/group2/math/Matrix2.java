package ru.vsu.cs.group2.math;

public class Matrix2 implements Matrix {

    public Vector2[] arr = new Vector2[2];

    public Matrix2(Vector2 v1, Vector2 v2) {
        arr[0] = v1;
        arr[1] = v2;
    }


    @Override
    public Vector2[] getArr() {
        return arr;
    }

    @Override
    public Matrix2 add(Matrix m) throws MathException {
        if (m.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector2[] mArr = ((Matrix2) m).getArr();
        return new Matrix2(arr[0].add(mArr[0]), arr[1].add(mArr[1]));
    }

    @Override
    public Matrix2 subtract(Matrix m) throws MathException {
        return add(m.multiply(-1));
    }

    @Override
    public Vector2 multiply(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector2 v2 = (Vector2) v;
        return new Vector2(arr[0].scalarMultiply(v2), arr[1].scalarMultiply(v2));
    }

    @Override
    public Matrix2 multiply(double a) {
        return new Matrix2(arr[0].multiply(a), arr[1].multiply(a));
    }

    @Override
    public Matrix2 transposition() {
        return new Matrix2(new Vector2(arr[0].x, arr[1].x), new Vector2(arr[0].y, arr[1].y));
    }

    @Override
    public double determinant() {
        return arr[0].x * arr[1].y - arr[0].y * arr[1].x;
    }
}
