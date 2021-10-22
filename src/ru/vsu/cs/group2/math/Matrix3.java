package ru.vsu.cs.group2.math;

public class Matrix3 implements Matrix {

    public Vector3[] arr = new Vector3[3];

    public Matrix3(Vector3 v1, Vector3 v2, Vector3 v3) {
        arr[0] = v1;
        arr[1] = v2;
        arr[2] = v3;
    }

    @Override
    public Vector3[] getArr() {
        return arr;
    }

    @Override
    public Matrix3 add(Matrix m) throws MathException {
        if (m.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector3[] mArr = ((Matrix3) m).getArr();
        return new Matrix3(arr[0].add(mArr[0]), arr[1].add(mArr[1]), arr[2].add(mArr[2]));
    }

    @Override
    public Matrix3 subtract(Matrix m) throws MathException {
        return add(m.multiply(-1));
    }

    @Override
    public Vector3 multiply(Vector v) throws MathException {
        if (v.getClass() != Vector3.class) {
            throw new MathException("Wrong class.");
        }
        Vector3 v3 = (Vector3) v;
        return new Vector3(arr[0].scalarMultiply(v3), arr[1].scalarMultiply(v3), arr[2].scalarMultiply(v3));
    }

    @Override
    public Matrix3 multiply(double a) {
        return new Matrix3(arr[0].multiply(a), arr[1].multiply(a), arr[2].multiply(a));
    }

    @Override
    public Matrix3 transposition() {
        return new Matrix3(new Vector3(arr[0].x, arr[1].x, arr[2].x),
                    new Vector3(arr[0].y, arr[1].y, arr[2].y),
                    new Vector3(arr[0].z, arr[1].z, arr[2].z));
    }

    @Override
    public double determinant() {
        return arr[0].x * new Matrix2(new Vector2(arr[1].y, arr[1].z), new Vector2(arr[2].y, arr[2].z)).determinant() -
                arr[0].y * new Matrix2(new Vector2(arr[1].x, arr[1].z), new Vector2(arr[2].x, arr[2].z)).determinant() +
                arr[0].z * new Matrix2(new Vector2(arr[1].x, arr[1].y), new Vector2(arr[2].x, arr[2].y)).determinant();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        boolean res = true;
        Vector3[] arr = getArr();
        Matrix3 m = (Matrix3) o;
        Vector3[] mArr = m.getArr();
        for (int i = 0; i < arr.length; i++) {
            res = res && arr[i].equals(mArr[i]);
        }
        return res;
    }

    public static Matrix3 getZeros() {
        return new Matrix3(new Vector3(0, 0, 0), new Vector3(0, 0, 0), new Vector3(0, 0, 0));
    }

    public static Matrix3 getOnes() {
        return new Matrix3(new Vector3(1, 0, 0), new Vector3(0, 1, 0), new Vector3(0, 0, 1));
    }
}
