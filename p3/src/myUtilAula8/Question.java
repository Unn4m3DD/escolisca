package myUtilAula8;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Question {
    private String imgPath, pergunta, a0, a1, a2, a3;
    private int difficulty;
    private int correctAwnser;

    public Question(String imgPath, String pergunta, String a0, String a1, String a2, String a3, int difficulty, int correctAwnser) {
        this.imgPath = imgPath;
        this.pergunta = pergunta;
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.difficulty = difficulty;
        this.correctAwnser = correctAwnser;
    }

    public static Question[] parseFile(String fName) {
        ArrayList<Question> result = new ArrayList<Question>();
        File f = new File(fName);
        try (Scanner fs = new Scanner(f)) {
            fs.nextLine();
            while (fs.hasNextLine()) {
                String[] l = fs.nextLine().split(";");
                result.add(new Question(l[0], l[1], l[2], l[3], l[4], l[5], Integer.parseInt(l[6]), Integer.parseInt(l[7])));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        Question[] res = new Question[result.size()];
        for (var i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public String getimgPath() {
        return imgPath;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getAArray() {
        return new String[]{a0, a1, a2, a3};
    }

    public String getA0() {
        return a0;
    }

    public String getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }

    public String getA3() {
        return a3;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getCorrectAwnser() {
        return correctAwnser;
    }
}
