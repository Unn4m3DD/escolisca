// Generated from C:/Users/guerr/IdeaProjects/LFA/src/test\paulo.g4 by ANTLR 4.8
package test;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pauloParser}.
 */
public interface pauloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pauloParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(pauloParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(pauloParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link pauloParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(pauloParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(pauloParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pauloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(pauloParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(pauloParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pauloParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(pauloParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(pauloParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link pauloParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(pauloParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(pauloParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link pauloParser#typedParams}.
	 * @param ctx the parse tree
	 */
	void enterTypedParams(pauloParser.TypedParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#typedParams}.
	 * @param ctx the parse tree
	 */
	void exitTypedParams(pauloParser.TypedParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link pauloParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(pauloParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link pauloParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(pauloParser.ParamsContext ctx);
}