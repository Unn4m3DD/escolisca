package aula2;

import antlr4.Ex1BaseVisitor;
import antlr4.Ex1Parser;

public class Ex1MyVisitor extends Ex1BaseVisitor<Object> {
    @Override
    public Object visitGreetings(Ex1Parser.GreetingsContext ctx) {
        System.out.println("Olá " + visit(ctx.name()));
        return null;
    }

    @Override
    public Object visitBye(Ex1Parser.ByeContext ctx) {
        System.out.println("Adeus " + visit(ctx.name()));
        return null;
    }

    @Override
    public Object visitName(Ex1Parser.NameContext ctx) {
        return (String)(ctx.name() != null ? visit(ctx.name()) : "") + " " + ctx.ID().getText();
    }
}
