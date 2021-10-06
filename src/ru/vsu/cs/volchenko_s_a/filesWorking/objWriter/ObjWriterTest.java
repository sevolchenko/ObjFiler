package ru.vsu.cs.volchenko_s_a.filesWorking.objWriter;

import org.junit.Test;

import ru.vsu.cs.volchenko_s_a.Model;

class ObjWriterTest {

    @Test
    public void checkModel() {
        System.out.println(ObjWriter.modelToString(new Model()));
    }
}