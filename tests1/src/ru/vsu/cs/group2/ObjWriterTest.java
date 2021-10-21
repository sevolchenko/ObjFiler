package ru.vsu.cs.group2;

import org.junit.jupiter.api.Test;

import ru.vsu.cs.group2.Model;
import ru.vsu.cs.group2.filesWorking.objReader.ObjReader;
import ru.vsu.cs.group2.filesWorking.objWriter.ObjWriter;

import java.io.*;

public class ObjWriterTest {

    @Test
    public void checkModelTeapot() throws IOException {
        Model model =  ObjReader.read("C:\\Users\\loide\\Downloads\\ObjFiler\\files\\input\\TeapotMaterials.obj");
        ObjWriter.modelToFile(model, "C:\\Users\\loide\\Downloads\\ObjFiler\\files\\output\\test1.obj");
    }

    @Test
    public void checkModelTorus() throws IOException {

        System.out.println(System.getProperty("user.dir"));
        Model model = ObjReader.read("C:\\Users\\loide\\Downloads\\ObjFiler\\files\\input\\Torus03.obj");
        ObjWriter.modelToFile(model, "C:\\Users\\loide\\Downloads\\ObjFiler\\files\\output\\test2.obj");
    }
}