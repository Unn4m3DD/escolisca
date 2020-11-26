package aula2.Ex3;

import aula2.Ex4.Ex4MyListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName("resources/ex3.txt");
        Ex3Lexer lexer = new Ex3Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex3Parser parser = new Ex3Parser(tokens);

        ParseTree tree = parser.program();
        Ex3MyVisitor visitor = new Ex3MyVisitor();
        visitor.visit(tree);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Ex4MyListener(), tree);

    }
}
