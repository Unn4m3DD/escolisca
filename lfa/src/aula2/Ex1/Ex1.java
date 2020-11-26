package aula2.Ex1;

import antlr4.Ex1Lexer;
import antlr4.Ex1Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName("resources/ex1.txt");
        Ex1Lexer lexer = new Ex1Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex1Parser parser = new Ex1Parser(tokens);

        ParseTree tree = parser.mainRule();
        Ex1MyVisitor visitor = new Ex1MyVisitor();
        visitor.visit(tree);
    }
}
