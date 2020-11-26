// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex1\Ex1.g4 by ANTLR 4.8
package aula2.Ex1;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex1Parser#mainRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainRule(Ex1Parser.MainRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex1Parser#greetings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreetings(Ex1Parser.GreetingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex1Parser#bye}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBye(Ex1Parser.ByeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex1Parser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(Ex1Parser.NameContext ctx);
}