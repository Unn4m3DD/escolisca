// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex1\Ex1.g4 by ANTLR 4.8
package aula2.Ex1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ex1Parser}.
 */
public interface Ex1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Ex1Parser#mainRule}.
	 * @param ctx the parse tree
	 */
	void enterMainRule(Ex1Parser.MainRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex1Parser#mainRule}.
	 * @param ctx the parse tree
	 */
	void exitMainRule(Ex1Parser.MainRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex1Parser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(Ex1Parser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex1Parser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(Ex1Parser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex1Parser#bye}.
	 * @param ctx the parse tree
	 */
	void enterBye(Ex1Parser.ByeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex1Parser#bye}.
	 * @param ctx the parse tree
	 */
	void exitBye(Ex1Parser.ByeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ex1Parser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(Ex1Parser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ex1Parser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(Ex1Parser.NameContext ctx);
}