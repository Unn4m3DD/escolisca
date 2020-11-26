// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex10/c\Ex10c.g4 by ANTLR 4.8
package aula2.Ex10.c;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ex10cParser}.
 */
public interface Ex10cListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Ex10cParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Ex10cParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10cParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Ex10cParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10cParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(Ex10cParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10cParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(Ex10cParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10cParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Ex10cParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10cParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Ex10cParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprJoin(Ex10cParser.ExprJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprJoin(Ex10cParser.ExprJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesis(Ex10cParser.ExprParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesis(Ex10cParser.ExprParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprId(Ex10cParser.ExprIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprId(Ex10cParser.ExprIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(Ex10cParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(Ex10cParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSet(Ex10cParser.ExprSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSet(Ex10cParser.ExprSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprExcept(Ex10cParser.ExprExceptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprExcept(Ex10cParser.ExprExceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10cParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(Ex10cParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10cParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(Ex10cParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10cParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(Ex10cParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10cParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(Ex10cParser.ItemContext ctx);
}