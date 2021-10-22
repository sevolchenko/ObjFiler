package ru.vsu.cs.volchenko_s_a;

import org.junit.jupiter.api.*;

import ru.vsu.cs.group2.math.*;


public class MathTests {

    @Test
    public void test1() throws MathException {
        Assertions.assertEquals(new Vector2(0, 2).normalized(), new Vector2(0, 1));
    }

    @Test
    public void test2() throws MathException {
        Assertions.assertEquals(new Vector3(2, 2, 2).normalized().length(), 1);
    }

    @Test
    public void test3() {
        Assertions.assertNotEquals(new Vector2(5, 2), new Vector3(5, 2, 0));
    }

    @Test
    public void test4() throws MathException {
        Assertions.assertEquals(new Vector3(5, 2, 5), new Vector3(5, 2, 0).add(new Vector3(0, 0, 5)));
    }

    @Test
    public void test5() {
        Assertions.assertEquals(new Vector4(4, 1, 3, 2), new Vector4(8, 2, 6, 4).divide(2));
    }


    @Test
    public void test6() {
        Matrix3 m = new Matrix3(new Vector3(5, 3, 5),
                new Vector3(2, 2, 2),
                new Vector3(1, 7, 4));
        Assertions.assertEquals(m.determinant(), 12);
    }

    @Test
    public void test7() throws MathException {
        Matrix3 m = new Matrix3(new Vector3(5, 3, 5),
                new Vector3(2, 2, 2),
                new Vector3(1, 7, 4));
        Vector3 v = new Vector3(1, 2, 3);
        Assertions.assertEquals(m.multiply(v), new Vector3(26, 12, 27));
    }

    @Test
    public void test8()  {
        Matrix3 m = new Matrix3(new Vector3(5, 3, 5),
                new Vector3(2, 2, 2),
                new Vector3(1, 7, 4));
        Matrix3 m2 = new Matrix3(new Vector3(5, 2, 1),
                new Vector3(3, 2, 7),
                new Vector3(5, 2, 4));
        Assertions.assertEquals(m.transposition(), m2);
    }

    @Test
    public void test9()  {
        Matrix3 m = new Matrix3(new Vector3(5, 3, 5),
                new Vector3(2, 2, 2),
                new Vector3(1, 7, 4));
        Matrix3 m2 = new Matrix3(new Vector3(5, 2, 1),
                new Vector3(3, 2, 7),
                new Vector3(5, 2, 4));
        Assertions.assertEquals(m2.transposition(), m);
    }

    @Test
    public void test10() throws MathException {
        Matrix3 m = new Matrix3(new Vector3(5, 3, 5),
                new Vector3(2, 2, 2),
                new Vector3(1, 7, 4));
        Matrix3 m2 = new Matrix3(new Vector3(1, 1, 1),
                new Vector3(1, 1, 1),
                new Vector3(1, 1, 1));
        Matrix3 m3 = new Matrix3(new Vector3(6, 4, 6),
                new Vector3(3, 3, 3),
                new Vector3(2, 8, 5));
        Assertions.assertEquals(m2.add(m), m3);
    }
}
