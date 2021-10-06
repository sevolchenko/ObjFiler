package ru.vsu.cs.volchenko_s_a.filesWorking.objReader;
import ru.vsu.cs.volchenko_s_a.Model;
import ru.vsu.cs.volchenko_s_a.Polygon;
import ru.vsu.cs.volchenko_s_a.Vector2f;
import ru.vsu.cs.volchenko_s_a.Vector3f;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class ObjReader {

    public static Model read(String fileContent) {
        Model result = new Model();

        int lineInd = 0;
        Scanner scanner = new Scanner(fileContent);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            ArrayList<String> wordsInLine = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
            if (wordsInLine.isEmpty())
                continue;

            final String token = wordsInLine.get(0);
            wordsInLine.remove(0);

            ++lineInd;
            switch (token) {
                // Обратите внимание!
                // Для структур типа вершин методы написаны так, чтобы ничего не знать о внешней среде.
                // Они принимают только то, что им нужно для работы, а возвращают только то, что могут создать.
                // Исключение - индекс строки. Он прокидывается, чтобы выводить сообщение об ошибке.
                // Могло быть иначе. Например, метод parseVertex мог вместо возвращения вершины принимать вектор вершин
                // модели или сам класс модели, работать с ним.
                // Но такой подход может привести к большему количеству ошибок в коде. Например, в нем что-то может
                // тайно сделаться с классом модели.
                // А еще это портит читаемость
                // И не стоит забывать про тесты. Чем проще вам задать данные для теста, проверить, что метод рабочий,
                // тем лучше.
                case Model.OBJ_VERTEX_TOKEN -> result.vertices.add(parseVertex(wordsInLine, lineInd));
                case Model.OBJ_TEXTURE_TOKEN -> result.textureVertices.add(parseTextureVertex(wordsInLine, lineInd));
                case Model.OBJ_NORMAL_TOKEN -> result.normals.add(parseNormal(wordsInLine, lineInd));
                // А здесь описанное выше правило нарушается, и это плохо. Например, очевидно, что тестировать такой
                // метод сложнее.
                // Подумайте и перепишите его так, чтобы с ним было легче работать.
                case Model.OBJ_POLYGON_TOKEN -> parsePolygon(
                        wordsInLine,
                        result.polygonVertexIndices,
                        result.polygonTextureVertexIndices,
                        result.polygonNormalIndices,
                        lineInd);
                default -> {}
            }
        }
        return result;
    }
    // Всем методам кроме основного я поставил модификатор доступа protected, чтобы обращаться к ним в тестах
    protected static Vector3f parseVertex(final ArrayList<String> wordsInLineWithoutToken, int lineInd) {
        try {
            return new Vector3f(
                    Float.parseFloat(wordsInLineWithoutToken.get(0)),
                    Float.parseFloat(wordsInLineWithoutToken.get(1)),
                    Float.parseFloat(wordsInLineWithoutToken.get(2)));

        } catch(NumberFormatException e) {
            throw new ObjReaderException("Failed to parse float value.", lineInd);

        } catch(IndexOutOfBoundsException e) {
            throw new ObjReaderException("Too few vertex arguments.", lineInd);
        }
    }

    protected static Vector2f parseTextureVertex(final ArrayList<String> wordsInLineWithoutToken, int lineInd) {
        try {
            return new Vector2f(
                    Float.parseFloat(wordsInLineWithoutToken.get(0)),
                    Float.parseFloat(wordsInLineWithoutToken.get(1)));

        } catch(NumberFormatException e) {
            throw new ObjReaderException("Failed to parse float value.", lineInd);

        } catch(IndexOutOfBoundsException e) {
            throw new ObjReaderException("Too few texture vertex arguments.", lineInd);
        }
    }

    protected static Vector3f parseNormal(final ArrayList<String> wordsInLineWithoutToken, int lineInd) {
        try {
            return new Vector3f(
                    Float.parseFloat(wordsInLineWithoutToken.get(0)),
                    Float.parseFloat(wordsInLineWithoutToken.get(1)),
                    Float.parseFloat(wordsInLineWithoutToken.get(2)));

        } catch(NumberFormatException e) {
            throw new ObjReaderException("Failed to parse float value.", lineInd);

        } catch(IndexOutOfBoundsException e) {
            throw new ObjReaderException("Too few normal arguments.", lineInd);
        }
    }

    protected static void parsePolygon(
            final ArrayList<String> wordsInLineWithoutToken, int lineInd) {
        Polygon polygon = new Polygon(onePolygonVertexIndices, onePolygonTextureVertexIndices, onePolygonNormalIndices);

        for (String s : wordsInLineWithoutToken) {
            parsePolygonWord(s, polygon);
        }
        polygon.polygonNormalVertexes.add(onePolygonIndices);
        polygon.polygonTextureVertexes.add(onePolygonTextureVertexIndices);
        polygon.polygonNormalVertexes.add(onePolygonNormalIndices);
//        polygonVertexIndices.add(onePolygonVertexIndices);
//        polygonTextureVertexIndices.add(onePolygonTextureVertexIndices);
//        polygonNormalIndices.add(onePolygonNormalIndices);
    }

    // Обратите внимание, что для чтения полигонов я выделил еще один вспомогательный метод.
    // Это бывает очень полезно и с точки зрения структурирования алгоритма в голове, и с точки зрения тестирования.
    // В радикальных случаях не бойтесь выносить в отдельные методы и тестировать код из одной-двух строчек.
    protected static void parsePolygonWord(
            String wordInLine, Polygon polygon, int lineInd) {
        try {
            String[] wordIndices = wordInLine.split("/");
            switch (wordIndices.length) {
                case 1 -> {
                    polygon.polygonVertexes.add(Integer.parseInt(wordIndices[0]) - 1);
                }
                case 2 -> {
                    polygon.polygonVertexes.add(Integer.parseInt(wordIndices[0]) - 1);
                    polygon.polygonTextureVertexes.add(Integer.parseInt(wordIndices[1]) - 1);
                }
                case 3 -> {
                    polygon.polygonVertexes.add(Integer.parseInt(wordIndices[0]) - 1);
                    polygon.polygonNormalVertexes.add(Integer.parseInt(wordIndices[2]) - 1);
                    if (!wordIndices[1].equals("")) {
                        polygon.polygonTextureVertexes.add(Integer.parseInt(wordIndices[1]) - 1);
                    }
                }
                default -> {
                    throw new ObjReaderException("Invalid element size.", lineInd);
                }
            }

        } catch(NumberFormatException e) {
            throw new ObjReaderException("Failed to parse int value.", lineInd);

        } catch(IndexOutOfBoundsException e) {
            throw new ObjReaderException("Too few arguments.", lineInd);
        }
    }




}
