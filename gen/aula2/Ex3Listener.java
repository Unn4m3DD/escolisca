// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2\Ex3.g4 by ANTLR 4.8
package aula2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ex3Parser}.
 */
public interface Ex3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Ex3Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Ex3Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex3Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Ex3Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex3Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(Ex3Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex3Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(Ex3Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(Ex3Parser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(Ex3Parser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(Ex3Parser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(Ex3Parser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(Ex3Parser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(Ex3Parser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInteger(Ex3Parser.ExprIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInteger(Ex3Parser.ExprIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(Ex3Parser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link Ex3Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(Ex3Parser.ExprMultDivModContext ctx);
}