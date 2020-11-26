package aula2.Ex8;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Ex8 {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName("resources/b2_08/p5.txt");
        Ex8Lexer lexer = new Ex8Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex8Parser parser = new Ex8Parser(tokens);

        ParseTree tree = parser.program();
        Ex8MyVisitor visitor = new Ex8MyVisitor();
        visitor.visit(tree);
    }
}
