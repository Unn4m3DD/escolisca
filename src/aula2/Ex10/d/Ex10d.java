package aula2.Ex10.d;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Ex10d {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        Ex10dLexer lexer = new Ex10dLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex10dParser parser = new Ex10dParser(tokens);

        ParseTree tree = parser.program();
        Ex10dMyVisitor visitor = new Ex10dMyVisitor();
        visitor.visit(tree);
    }
}
