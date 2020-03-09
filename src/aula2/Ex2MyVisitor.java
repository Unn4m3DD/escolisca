package aula2;

public class Ex2MyVisitor extends Ex2BaseVisitor<Object> {

    @Override
    public Object visitStat(Ex2Parser.StatContext ctx) {
        System.out.println(visit(ctx.expr()));
        return null;
    }

    @Override
    public Object visitExprSuffix(Ex2Parser.ExprSuffixContext ctx) {
        return ctx.op.getText().equals("+") ? (Double) visit(ctx.e1) + (Double) visit(ctx.e2) :
                ctx.op.getText().equals("-") ? (Double) visit(ctx.e1) - (Double) visit(ctx.e2) :
                        ctx.op.getText().equals("*") ? (Double) visit(ctx.e1) * (Double) visit(ctx.e2) :
                                (Double) visit(ctx.e1) / (Double) visit(ctx.e2);
    }

    @Override
    public Object visitExprNumber(Ex2Parser.ExprNumberContext ctx) {
        return Double.parseDouble(ctx.getText());
    }
}
