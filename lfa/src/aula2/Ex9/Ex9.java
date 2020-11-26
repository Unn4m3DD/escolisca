package aula2.Ex9;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        Ex9Lexer lexer = new Ex9Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex9Parser parser = new Ex9Parser(tokens);

        ParseTree tree = parser.program();
        Ex9MyVisitor visitor = new Ex9MyVisitor();
        Question[] questions = (Question[]) visitor.visit(tree);

        LinkedList<Question> availableQuestions = new LinkedList<>();
        for (Question question : questions) {
            if (question.id2.equals(args[1]))
                availableQuestions.add(question);
        }
        Question selectedQuestion = availableQuestions.get((int) (Math.random() * availableQuestions.size()));
        System.out.println("- " + selectedQuestion.question);
        for (int i = 0; i < Integer.parseInt(args[2]) && i < selectedQuestion.answers.length; i++) {
            System.out.println("   " + (char) (i + 65) + ") " + selectedQuestion.answers[i]);
        }
        String answer = (new Scanner(System.in)).next();
        System.out.println(selectedQuestion.points[(int)(answer.charAt(0) - 65)]);
    }
}
