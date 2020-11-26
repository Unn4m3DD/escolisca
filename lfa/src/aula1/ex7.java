package aula1;

public class ex7 {
    public static void main(String[] args) {

        ExpressionTree et1 = ExpressionTree.fromPrefixNotation("+ 1 2");
        ExpressionTree et2 = ExpressionTree.fromPrefixNotation("+ / 2 3 - 2 * 2 1");
        ExpressionTree et3 = ExpressionTree.fromPrefixNotation("+ 1 2");

        System.out.println(et1.stringPostfix() + " = " + et1.eval());
        System.out.println(et2.stringPrefix() + " = " + et2.eval());
        System.out.println(et3.stringPostfix() + " = " + et3.eval());
    }
}
