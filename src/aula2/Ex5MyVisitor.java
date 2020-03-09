package aula2;

import java.util.HashMap;

public class Ex5MyVisitor extends Ex5BaseVisitor<Object> {
    HashMap<String, Integer> vars = new HashMap<>();

    @Override
    public Object visitExprUnary(Ex5Parser.ExprUnaryContext ctx) {
        return (ctx.unaryOp.getText().equals("+") ? 1 : -1) * (Integer) visit(ctx.expr());
    }

    @Override
    public Object visitStatExpr(Ex5Parser.StatExprContext ctx) {
        System.out.println(visit(ctx.expr()));
        return null;
    }

    @Override
    public Object visitAssignment(Ex5Parser.AssignmentContext ctx) {
        vars.put(ctx.ID().getText(), (Integer) visit(ctx.expr()));
        return null;
    }

    @Override
    public Object visitExprID(Ex5Parser.ExprIDContext ctx) {
        if (!vars.containsKey(ctx.ID().getText())) {
            System.err.println("Identifier \"" + ctx.ID().getText() + "\" not defined");
            System.exit(1);
        }
        return vars.get(ctx.ID().getText());
    }

    @Override
    public Object visitExprMultDivMod(Ex5Parser.ExprMultDivModContext ctx) {
        return ctx.op.getText().equals("*") ? (Integer) visit(ctx.e1) * (Integer) visit(ctx.e2) :
                ctx.op.getText().equals("/") ? (Integer) visit(ctx.e1) / (Integer) visit(ctx.e2) :
                        (Integer) visit(ctx.e1) % (Integer) visit(ctx.e2);
    }

    @Override
    public Object visitExprAddSub(Ex5Parser.ExprAddSubContext ctx) {
        return ctx.op.getText().equals("+") ? (Integer) visit(ctx.e1) + (Integer) visit(ctx.e2) :
                (Integer) visit(ctx.e1) - (Integer) visit(ctx.e2);
    }

    @Override
    public Object visitExprInteger(Ex5Parser.ExprIntegerContext ctx) {
        return Integer.parseInt(ctx.Integer().getText());
    }

    @Override
    public Object visitExprParent(Ex5Parser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }
}
