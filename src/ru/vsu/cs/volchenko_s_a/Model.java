package ru.vsu.cs.volchenko_s_a;

import java.util.ArrayList;


public class Model {

    public static final String OBJ_VERTEX_TOKEN = "v";
    public static final String OBJ_TEXTURE_TOKEN = "vt";
    public static final String OBJ_NORMAL_TOKEN = "vn";
    public static final String OBJ_POLYGON_TOKEN = "f";

    public final ArrayList<Vector3f> vertices = new ArrayList<>();
    public final ArrayList<Vector2f> textureVertices = new ArrayList<>();
    public final ArrayList<Vector3f> normals = new ArrayList<>();

    public final ArrayList<Polygon> polygons = new ArrayList<>();

    public Model(ArrayList<Vector3f> vertices, ArrayList<Vector2f> textureVertices, ArrayList<Vector3f> normals, ArrayList<Polygon> polygons) {
        this.vertices.addAll(vertices);
        this.textureVertices.addAll(textureVertices);
        this.normals.addAll(normals);
        this.polygons.addAll(polygons);
    }

    public Model() {

    }

}
