package aula2.Ex10.b;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Ex10b {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        Ex10bLexer lexer = new Ex10bLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex10bParser parser = new Ex10bParser(tokens);

        ParseTree tree = parser.program();
        Ex10bMyListener listener = new Ex10bMyListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
    }
}
