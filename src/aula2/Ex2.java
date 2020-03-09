package aula2;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName("resources/ex2.txt");
        Ex2Lexer lexer = new Ex2Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex2Parser parser = new Ex2Parser(tokens);

        ParseTree tree = parser.stat();
        Ex2MyVisitor visitor = new Ex2MyVisitor();
        visitor.visit(tree);
    }
}
