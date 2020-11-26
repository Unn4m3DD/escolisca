package aula2.Ex10.c;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Ex10c {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        Ex10cLexer lexer = new Ex10cLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex10cParser parser = new Ex10cParser(tokens);

        ParseTree tree = parser.program();
        Ex10cMyListener listener = new Ex10cMyListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
    }
}
