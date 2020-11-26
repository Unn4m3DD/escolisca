package aula2.Ex5;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Ex5 {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName("resources/ex5.txt");
        Ex5Lexer lexer = new Ex5Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex5Parser parser = new Ex5Parser(tokens);

        ParseTree tree = parser.program();
        Ex5MyVisitor visitor = new Ex5MyVisitor();
        visitor.visit(tree);
    }
}
