package ru.vsu.cs.group2.math;

public class Vector3 implements Vector {

    public double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 vectorMultiply(Vector3 v) {
        return new Vector3(y * v.z - z * v.y, x * v.z - z * v.x, x * v.y - y * v.x);
    }

    @Override
    public Vector3 add(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector3 v3 = (Vector3) v;
        return new Vector3(x + v3.x, y + v3.y, z + v3.z);
    }

    @Override
    public Vector3 subtract(Vector v) throws MathException {
        return add(v.multiply(-1));
    }

    @Override
    public Vector3 multiply(double a) {
        return new Vector3(x * a, y * a, z * a);
    }

    @Override
    public Vector3 divide(double a) {
        return multiply(1 / a);
    }

    @Override
    public double scalarMultiply(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector3 v3 = (Vector3) v;
        return x * v3.x + y * v3.y + z * v3.z;
    }

    @Override
    public Vector3 normalized() throws MathException {
        return divide(length());
    }
}
