package ru.vsu.cs.group2.math;

public class Matrix4 implements Matrix {

    public Vector4[] arr = new Vector4[4];

    public Matrix4(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4) {
        arr[0] = v1;
        arr[1] = v2;
        arr[2] = v3;
        arr[3] = v4;
    }

    @Override
    public Vector4[] getArr() {
        return arr;
    }

    @Override
    public Matrix4 add(Matrix m) throws MathException {
        if (m.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector4[] mArr = ((Matrix4) m).getArr();
        return new Matrix4(arr[0].add(mArr[0]), arr[1].add(mArr[1]), arr[2].add(mArr[2]), arr[3].add(mArr[3]));
    }

    @Override
    public Matrix4 subtract(Matrix m) throws MathException {
        return add(m.multiply(-1));
    }

    @Override
    public Vector4 multiply(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector4 v4 = (Vector4) v;
        return new Vector4(arr[0].scalarMultiply(v4), arr[1].scalarMultiply(v4), arr[2].scalarMultiply(v4), arr[3].scalarMultiply(v4));
    }

    @Override
    public Matrix4 multiply(double a) {
        return new Matrix4(arr[0].multiply(a), arr[1].multiply(a), arr[2].multiply(a), arr[3].multiply(a));
    }

    @Override
    public Matrix4 transposition() {
        return new Matrix4 (new Vector4(arr[0].x, arr[1].x, arr[2].x, arr[3].x),
                new Vector4(arr[0].y, arr[1].y, arr[2].y, arr[3].y),
                new Vector4(arr[0].z, arr[1].z, arr[2].z, arr[3].z),
                new Vector4(arr[0].w, arr[1].w, arr[2].w, arr[3].w));
    }

    @Override
    public double determinant() {
        return arr[0].x * new Matrix3(new Vector3(arr[1].y, arr[1].z, arr[1].w), new Vector3(arr[2].y, arr[2].z, arr[2].w),  new Vector3(arr[3].y, arr[3].z, arr[3].w)).determinant() -
                arr[0].y * new Matrix3(new Vector3(arr[1].x, arr[1].z, arr[1].w), new Vector3(arr[2].x, arr[2].z, arr[2].w), new Vector3(arr[3].x, arr[3].z, arr[3].w)).determinant() +
                arr[0].z * new Matrix3(new Vector3(arr[1].x, arr[1].y, arr[1].w), new Vector3(arr[2].x, arr[2].y, arr[2].w), new Vector3(arr[3].x, arr[3].y, arr[3].w)).determinant() -
                arr[0].w * new Matrix3(new Vector3(arr[1].x, arr[1].y, arr[1].z), new Vector3(arr[2].x, arr[2].y, arr[1].z), new Vector3(arr[3].x, arr[3].y, arr[3].z)).determinant();
    }

}

