package aula2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class problema2 {
    static char[][] tabuleiro = new char[80][80];
    static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("puzzle.txt");
        Scanner fs = new Scanner(f);
        boolean puzzleEnd = false;
        int tabCounter = 0;
        while (fs.hasNext()) {
            String line = fs.nextLine().toLowerCase();
            line = line.replace(",", ";").replace(" ", ";");
            puzzleEnd = line.contains(";");
            if (!puzzleEnd) {
                System.arraycopy(line.toCharArray(), 0, tabuleiro[tabCounter], 0, line.toCharArray().length);
                tabCounter++;
            } else {
                String[] preParsedWords = line.split(";");
                for (String s : preParsedWords) {
                    if (s.length() > 0) words.add(s);
                }
            }
        }
        for (String s : words) {
            Response res;
            if (s.equals("tree"))
                res = find(s);
            else
                res = find(s);
            System.out.printf("%2.2s, %2.2s %8.8s %s\n", res.x, res.y, res.dir, s);
        }
        System.out.println(words);

    }

    private static Response find(String s) {
        for (int y = 0; y < 80 - s.length(); y++) {
            for (int x = 0; x < 80 - s.length(); x++) {
                if (tabuleiro[y][x] == '\u0000') continue;
                if (y == 4)
                    assert true;
                String toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y][x + i];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "Right");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y][x - i];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "Left");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y - i][x];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "Up");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y + i][x];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "Down");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y + i][x + i];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "RightDown");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y - i][x + i];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "RightUp");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y + i][x - i];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "LeftDown");

                toTest = "";
                for (int i = 0; i < s.length(); i++) {
                    try {
                        toTest += tabuleiro[y - i][x - i];
                    } catch (Exception e) {
                    }
                }
                if (toTest.equals(s)) return new Response(x, y, "LeftUp");

            }
        }
        return null;
    }

}

class Response {
    int x, y;
    String dir;

    public Response(int x, int y, String dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}