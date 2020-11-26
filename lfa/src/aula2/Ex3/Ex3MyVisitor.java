package aula2.Ex3;


public class Ex3MyVisitor extends Ex3BaseVisitor<Object> {
    @Override
    public Object visitExprUnary(Ex3Parser.ExprUnaryContext ctx) {
        return (ctx.unaryOp.getText().equals("+") ? 1 : -1) * (Integer) visit(ctx.expr());
    }

    @Override
    public Object visitStat(Ex3Parser.StatContext ctx) {
        System.out.println(visit(ctx.expr()));
        return null;
    }

    @Override
    public Object visitExprMultDivMod(Ex3Parser.ExprMultDivModContext ctx) {
        return ctx.op.getText().equals("*") ? (Integer) visit(ctx.e1) * (Integer) visit(ctx.e2) :
                ctx.op.getText().equals("/") ? (Integer) visit(ctx.e1) / (Integer) visit(ctx.e2) :
                        (Integer) visit(ctx.e1) % (Integer) visit(ctx.e2);
    }

    @Override
    public Object visitExprAddSub(Ex3Parser.ExprAddSubContext ctx) {
        return ctx.op.getText().equals("+") ? (Integer) visit(ctx.e1) + (Integer) visit(ctx.e2) :
                (Integer) visit(ctx.e1) - (Integer) visit(ctx.e2);
    }

    @Override
    public Object visitExprInteger(Ex3Parser.ExprIntegerContext ctx) {
        return Integer.parseInt(ctx.Integer().getText());
    }

    @Override
    public Object visitExprParent(Ex3Parser.ExprParentContext ctx) {
        return visit(ctx.expr());
    }
}
