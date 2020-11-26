// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex10/c\Ex10c.g4 by ANTLR 4.8
package aula2.Ex10.c;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex10cParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex10cVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex10cParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Ex10cParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10cParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Ex10cParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10cParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Ex10cParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprJoin(Ex10cParser.ExprJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(Ex10cParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(Ex10cParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(Ex10cParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSet(Ex10cParser.ExprSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10cParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprExcept(Ex10cParser.ExprExceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10cParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(Ex10cParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10cParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(Ex10cParser.ItemContext ctx);
}