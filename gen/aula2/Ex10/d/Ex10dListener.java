// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex10/d\Ex10d.g4 by ANTLR 4.8
package aula2.Ex10.d;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ex10dParser}.
 */
public interface Ex10dListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Ex10dParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Ex10dParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10dParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Ex10dParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10dParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(Ex10dParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10dParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(Ex10dParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10dParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Ex10dParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10dParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Ex10dParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprJoin(Ex10dParser.ExprJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprJoin(Ex10dParser.ExprJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParenthesis(Ex10dParser.ExprParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParenthesis(Ex10dParser.ExprParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprId(Ex10dParser.ExprIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprId(Ex10dParser.ExprIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(Ex10dParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(Ex10dParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSet(Ex10dParser.ExprSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSet(Ex10dParser.ExprSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprExcept(Ex10dParser.ExprExceptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprExcept(Ex10dParser.ExprExceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10dParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(Ex10dParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10dParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(Ex10dParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex10dParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(Ex10dParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex10dParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(Ex10dParser.ItemContext ctx);
}