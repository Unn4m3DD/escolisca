// Generated from C:/Users/guerr/IdeaProjects/LFA/src/aula2/Ex10/a\Ex10a.g4 by ANTLR 4.8
package aula2.Ex10.a;

import java.util.*;
import aula2.Ex10.MyHashSet;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex10aParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex10aVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex10aParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Ex10aParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10aParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Ex10aParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10aParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Ex10aParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10aParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Ex10aParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10aParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(Ex10aParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex10aParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(Ex10aParser.ItemContext ctx);
}