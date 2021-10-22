package ru.vsu.cs.group2.math;

public class Vector4 implements Vector {

    public double x, y, z, w;

    public Vector4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Vector4 add(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector4 v4 = (Vector4) v;
        return new Vector4(x + v4.x, y + v4. y, z + v4.z, w + v4.w);
    }

    @Override
    public Vector4 subtract(Vector v) throws MathException {
        return add(v.multiply(-1));
    }

    @Override
    public Vector4 multiply(double a) {
        return new Vector4(x * a, y * a, z * a, w * a);
    }

    @Override
    public Vector4 divide(double a) {
        return multiply(1 / a);
    }


    @Override
    public double scalarMultiply(Vector v) throws MathException {
        if (v.getClass() != getClass()) {
            throw new MathException("Wrong class.");
        }
        Vector4 v4 = (Vector4) v;
        return x * v4.x + y * v4.y + z * v4.z + w * v4.w;
    }

    @Override
    public Vector4 normalized() throws MathException {
        return divide(length());
    }

    @Override
    public boolean equals(Object o) {
        double eps = 1e-7f;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector4 v4 = (Vector4) o;
        return Math.abs(x - v4.x) < eps && Math.abs(y - v4.y) < eps && Math.abs(z - v4.z) < eps && Math.abs(w - v4.w) < eps;
    }
}
