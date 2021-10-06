package ru.vsu.cs.volchenko_s_a.filesWorking.objWriter;

import ru.vsu.cs.volchenko_s_a.Model;
import ru.vsu.cs.volchenko_s_a.Polygon;
import ru.vsu.cs.volchenko_s_a.Vector2f;
import ru.vsu.cs.volchenko_s_a.Vector3f;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ObjWriter {

    public static void modelToFile(Model model, String filename) throws FileNotFoundException {
        if (!filename.toLowerCase().endsWith(".obj")) {
            filename += ".obj";
        }
        File file = new File(filename);
        PrintWriter out = new PrintWriter(file);
        out.print(modelToString(model));
    }

    public static String modelToString(Model model) {
        StringBuilder sb = new StringBuilder();

        sb.append(verticesToString(model.OBJ_VERTEX_TOKEN, model.vertices));
        sb.append("\n");

        sb.append(textureVerticesToString(model.OBJ_TEXTURE_TOKEN, model.textureVertices));
        sb.append("\n");

        sb.append(normalsToString(model.OBJ_NORMAL_TOKEN, model.normals));
        sb.append("\n");

        sb.append(polygonsToString(model.OBJ_POLYGON_TOKEN, model.polygons));

        return sb.toString();
    }

    private static String verticesToString(String token, List<Vector3f> vertices) {
        StringBuilder res = new StringBuilder();
        for (Vector3f v : vertices) {
            StringBuilder sb = new StringBuilder();
            sb.append(token + " ");
            sb.append(v.x + " " + v.y + " " + v.z);
            res.append(sb + "\n");
        }
        return res.toString();
    }

    private static String textureVerticesToString(String token, List<Vector2f> textureVertices) {
        StringBuilder res = new StringBuilder();
        for (Vector2f v : textureVertices) {
            StringBuilder sb = new StringBuilder();
            sb.append(token + " ");
            sb.append(v.x + " " + v.y);
            res.append(sb + "\n");
        }
        return res.toString();
    }

    private static String normalsToString(String token, List<Vector3f> normals) {
        StringBuilder res = new StringBuilder();
        for (Vector3f v : normals) {
            StringBuilder sb = new StringBuilder();
            sb.append(token + " ");
            sb.append(v.x + " " + v.y + " " + v.z);
            res.append(sb + "\n");
        }
        return res.toString();
    }

    private static String polygonsToString(String token, List<Polygon> polygons) {
        StringBuilder res = new StringBuilder();
        for (Polygon p : polygons) {
            StringBuilder sb = new StringBuilder();
            sb.append(token + " ");
            for (int i = 0; i < p.polygonVertexes.size(); i++) {
                sb.append(p.polygonVertexes.get(i) + 1);
                if (p.polygonNormalVertexes.size() >= 0) {
                   sb.append("//" + p.polygonNormalVertexes.get(i) + 1);
                }
                if (p.polygonTextureVertexes.size() >= 0) {
                    sb.insert(sb.indexOf("/"), p.polygonTextureVertexes.get(i) + 1);
                }
                sb.append(" ");
            }
            res.append(sb + "\n");
        }
        return res.toString();
    }

}
