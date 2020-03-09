package aula2;

import java.util.HashMap;

public class Ex8MyVisitor extends Ex8BaseVisitor<Object> {
    // TODO: 09/03/2020 aceitar input do user
    class Fraction {
        private int gdc(int n1, int n2) {
            if (n2 == 0) {
                return n1;
            }
            return gdc(n2, n1 % n2);
        }

        private int num, den;

        Fraction(int num, int den) {
            this.num = num;
            this.den = den;
            simplify();
        }

        private double reduce() {
            return (double) this.num / (double) this.den;
        }

        private void simplify() {
            int gdc = gdc(num, den);
            num /= gdc;
            den /= gdc;
        }

        public Fraction add(Fraction other) {
            return new Fraction(this.num * other.den + other.num * this.den, this.den * other.den);
        }

        public Fraction sub(Fraction other) {
            return new Fraction(this.num * other.den - other.num * this.den, this.den * other.den);
        }

        public Fraction mult(Fraction other) {
            return new Fraction(this.num * other.num, this.den * other.den);
        }

        public Fraction div(Fraction other) {
            return new Fraction(this.num * other.den, this.den * other.num);
        }

        public Fraction pow(Fraction power) {
            return new Fraction((int) Math.pow(this.num, power.reduce()), (int) Math.pow(this.den, power.reduce()));
        }

        @Override
        public String toString() {
            return num + (den != 1 ? "/" + den : "");
        }
    }

    HashMap<String, Fraction> vars = new HashMap<>();

    @Override
    public Object visitExprID(Ex8Parser.ExprIDContext ctx) {
        return vars.get(ctx.ID().getText());
    }

    @Override
    public Object visitExprPrecedence2(Ex8Parser.ExprPrecedence2Context ctx) {
        return ctx.op2().getText().equals("+") ? ((Fraction) visit(ctx.e1)).add((Fraction) visit(ctx.e2)) :
                ((Fraction) visit(ctx.e1)).sub((Fraction) visit(ctx.e2));
    }

    @Override
    public Object visitExprReduce(Ex8Parser.ExprReduceContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitExprParenthesis(Ex8Parser.ExprParenthesisContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitExprPrecedence1(Ex8Parser.ExprPrecedence1Context ctx) {
        return ctx.op1().getText().equals("*") ? ((Fraction) visit(ctx.e1)).mult((Fraction) visit(ctx.e2)) :
                ctx.op1().getText().equals(":") ? ((Fraction) visit(ctx.e1)).div((Fraction) visit(ctx.e2)) :
                        ((Fraction) visit(ctx.e1)).pow((Fraction) visit(ctx.e2));
    }

    @Override
    public Object visitExprUnary(Ex8Parser.ExprUnaryContext ctx) {
        return ((Fraction) visit(ctx.expr())).mult(new Fraction(ctx.unaryOP.getText().equals("+") ? 1 : -1, 1));
    }


    @Override
    public Object visitFracDenNum(Ex8Parser.FracDenNumContext ctx) {
        return new Fraction(Integer.parseInt(ctx.num.getText()), Integer.parseInt(ctx.den.getText()));
    }

    @Override
    public Object visitFracNumber(Ex8Parser.FracNumberContext ctx) {
        return new Fraction(Integer.parseInt(ctx.Number().getText()), 1);
    }

    @Override
    public Object visitPrint(Ex8Parser.PrintContext ctx) {
        System.out.println(visit(ctx.expr()));
        return null;
    }

    @Override
    public Object visitAssignment(Ex8Parser.AssignmentContext ctx) {
        vars.put(ctx.ID().getText(), (Fraction) visit(ctx.expr()));
        return null;
    }
}
