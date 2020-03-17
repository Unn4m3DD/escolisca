// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex2\Ex2.g4 by ANTLR 4.8
package aula2.Ex2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex2Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Ex2Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex2Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Ex2Parser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link Ex2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(Ex2Parser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSuffix}
	 * labeled alternative in {@link Ex2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSuffix(Ex2Parser.ExprSuffixContext ctx);
}