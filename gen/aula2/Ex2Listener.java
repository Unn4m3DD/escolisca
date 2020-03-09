// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2\Ex2.g4 by ANTLR 4.8
package aula2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ex2Parser}.
 */
public interface Ex2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Ex2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Ex2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Ex2Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(Ex2Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(Ex2Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link Ex2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(Ex2Parser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link Ex2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(Ex2Parser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSuffix}
	 * labeled alternative in {@link Ex2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSuffix(Ex2Parser.ExprSuffixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSuffix}
	 * labeled alternative in {@link Ex2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSuffix(Ex2Parser.ExprSuffixContext ctx);
}