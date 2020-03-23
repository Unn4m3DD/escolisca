// Generated from C:/Users/guerr/IdeaProjects/LFA/src/test\paulo.g4 by ANTLR 4.8
package test;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pauloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pauloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pauloParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(pauloParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link pauloParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(pauloParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link pauloParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(pauloParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pauloParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(pauloParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link pauloParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(pauloParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link pauloParser#typedParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedParams(pauloParser.TypedParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link pauloParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(pauloParser.ParamsContext ctx);
}