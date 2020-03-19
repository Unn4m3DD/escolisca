// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex10/b\Ex10b.g4 by ANTLR 4.8
package aula2.Ex10.b;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex10bParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex10bVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex10bParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Ex10bParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10bParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Ex10bParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10bParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Ex10bParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprJoin}
	 * labeled alternative in {@link Ex10bParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprJoin(Ex10bParser.ExprJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link Ex10bParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(Ex10bParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprId}
	 * labeled alternative in {@link Ex10bParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(Ex10bParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link Ex10bParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(Ex10bParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSet}
	 * labeled alternative in {@link Ex10bParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSet(Ex10bParser.ExprSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprExcept}
	 * labeled alternative in {@link Ex10bParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprExcept(Ex10bParser.ExprExceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10bParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(Ex10bParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10bParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(Ex10bParser.ItemContext ctx);
}