package ru.vsu.cs.volchenko_s_a;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

    // три списка одинаковой длины. второй и третий могут и остаться незаполненными

    public final ArrayList<Integer> polygonVertexes = new ArrayList<>();
    public final ArrayList<Integer> polygonTextureVertexes = new ArrayList<>();
    public final ArrayList<Integer> polygonNormalVertexes = new ArrayList<>();

    public Polygon(List<Integer> polygonVertexes, List<Integer> polygonTextureVertexes, List<Integer> polygonNormalVertexes) {
        //проверка длины первого списка
        //проверка на равенство длин
        this.polygonVertexes.addAll(polygonVertexes);
        this.polygonTextureVertexes.addAll(polygonTextureVertexes);
        this.polygonNormalVertexes.addAll(polygonNormalVertexes);
    }

    public void addToPolygon (int indexV, int indexVt,  int indexVn) {

        if (indexVt > -1) {
            polygonTextureVertexes.add(indexVt);
        }
        if (indexVn > -1) {
            if (polygonNormalVertexes.size() == 0 && polygonVertexes.size() != 0) {
                //throw PolygonException
            }
            polygonNormalVertexes.add(indexVn);
        }

        polygonVertexes.add(indexV);
    }

}
