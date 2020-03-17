package aula2.Ex10.a;


import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        Ex10aLexer lexer = new Ex10aLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Ex10aParser parser = new Ex10aParser(tokens);
        parser.setBuildParseTree(false);
        parser.program();
    }

}
