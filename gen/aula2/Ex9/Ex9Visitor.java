// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex9\Ex9.g4 by ANTLR 4.8
package aula2.Ex9;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex9Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex9Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex9Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Ex9Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex9Parser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(Ex9Parser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex9Parser#opts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpts(Ex9Parser.OptsContext ctx);
}