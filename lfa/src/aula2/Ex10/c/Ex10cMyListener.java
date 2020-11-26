package aula2.Ex10.c;

import aula2.Ex10.MyHashSet;
import aula2.Ex10.d.Ex10dParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Set;

public class Ex10cMyListener extends Ex10cBaseListener {
    HashMap<String, Set<String>> vars = new HashMap<>();
    ParseTreeProperty<Object> ptp = new ParseTreeProperty<>();
/*
    @Override
    public Object visitStat(Ex10dParser.StatContext ctx) {
        System.out.println("result: " + visit(ctx.children.get(0)));
        return null;
    }

    @Override
    public Object visitAssignment(Ex10dParser.AssignmentContext ctx) {
        Set<String> set = (Set<String>) visit(ctx.expr());
        vars.put(ctx.ID().getText(), set);
        return set;
    }

    @Override
    public Object visitSet(Ex10dParser.SetContext ctx) {
        Set<String> set = new MyHashSet();
        for (Ex10dParser.ItemContext itemContext : ctx.item()) {
            set.add(itemContext.getText());
        }
        return set;
    }

    @Override
    public Object visitExprId(Ex10dParser.ExprIdContext ctx) {
        return vars.get(ctx.ID().getText());
    }

    @Override
    public Object visitExprSet(Ex10dParser.ExprSetContext ctx) {
        return visit(ctx.set());
    }

    @Override
    public Object visitExprJoin(Ex10dParser.ExprJoinContext ctx) {
        Set<String> s1 = (Set<String>) visit(ctx.e1);
        Set<String> s2 = (Set<String>) visit(ctx.e2);
        s1.retainAll(s2);
        return s1;
    }

    @Override
    public Object visitExprExcept(Ex10dParser.ExprExceptContext ctx) {
        Set<String> s1 = (Set<String>) visit(ctx.e1);
        Set<String> s2 = (Set<String>) visit(ctx.e2);
        s1.removeAll(s2);
        return s1;
    }

    @Override
    public Object visitExprAdd(Ex10dParser.ExprAddContext ctx) {
        Set<String> s1 = (Set<String>) visit(ctx.e1);
        Set<String> s2 = (Set<String>) visit(ctx.e2);
        s1.addAll(s2);
        return s1;
    }

    @Override
    public Object visitExprParenthesis(Ex10dParser.ExprParenthesisContext ctx) {
        return visit(ctx.expr());
    }
 */
}
