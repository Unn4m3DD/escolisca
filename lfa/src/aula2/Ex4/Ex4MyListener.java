package aula2.Ex4;

import aula2.Ex3.Ex3BaseListener;
import aula2.Ex3.Ex3Parser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;

public class Ex4MyListener extends Ex3BaseListener {
    Stack<Object> stack = new Stack<>();

        @Override
    public void exitExprUnary(Ex3Parser.ExprUnaryContext ctx) {
        stack.push((ctx.unaryOp.getText().equals("+") ? 1 : -1) * (Integer) (stack.peek() != null ? stack.pop() : 1));
    }

    @Override
    public void exitStat(Ex3Parser.StatContext ctx) {
        System.out.println(stack.pop());
    }

    @Override
    public void exitExprMultDivMod(Ex3Parser.ExprMultDivModContext ctx) {
        Integer elem2 = (Integer) stack.pop();
        Integer elem1 = (Integer) stack.pop();
        stack.push(ctx.op.getText().equals("*") ? (Integer) elem1 * (Integer) elem2 :
                ctx.op.getText().equals("/") ? (Integer) elem1 / (Integer) elem2 :
                        (Integer) elem1 % (Integer) elem2);
    }

    @Override
    public void exitExprAddSub(Ex3Parser.ExprAddSubContext ctx) {
        Integer elem2 = (Integer) stack.pop();
        Integer elem1 = (Integer) stack.pop();
        stack.push(ctx.op.getText().equals("+") ? (Integer) elem1 + (Integer) elem2 :
                (Integer) elem1 - (Integer) elem2);
    }

    @Override
    public void exitExprInteger(Ex3Parser.ExprIntegerContext ctx) {
        stack.push(Integer.parseInt(ctx.Integer().getText()));
    }

    @Override
    public void exitExprParent(Ex3Parser.ExprParentContext ctx) {
        stack.push(stack.pop());
    }
}
