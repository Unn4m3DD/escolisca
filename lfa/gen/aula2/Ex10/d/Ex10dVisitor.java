// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex10/d\Ex10d.g4 by ANTLR 4.8
package aula2.Ex10.d;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex10dParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex10dVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex10dParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Ex10dParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10dParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Ex10dParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10dParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Ex10dParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprJoin(Ex10dParser.ExprJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(Ex10dParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(Ex10dParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(Ex10dParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSet(Ex10dParser.ExprSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10dParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprExcept(Ex10dParser.ExprExceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10dParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(Ex10dParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10dParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(Ex10dParser.ItemContext ctx);
}