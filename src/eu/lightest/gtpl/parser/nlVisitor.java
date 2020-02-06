// Generated from nl.g4 by ANTLR 4.7.1
package eu.lightest.gtpl.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link nlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface nlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link nlParser#nl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNl(nlParser.NlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PolicyRule}
	 * labeled alternative in {@link nlParser#policyrules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicyRule(nlParser.PolicyRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Input}
	 * labeled alternative in {@link nlParser#inputformat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(nlParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FormatName}
	 * labeled alternative in {@link nlParser#concreteformat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatName(nlParser.FormatNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constraint}
	 * labeled alternative in {@link nlParser#constraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(nlParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link nlParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeName(nlParser.AttributeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(nlParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(nlParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(nlParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqual(nlParser.LessThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(nlParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanOrEqual(nlParser.GreaterThanOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs(nlParser.IsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsEquivalent}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEquivalent(nlParser.IsEquivalentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsDelegationFrom}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsDelegationFrom(nlParser.IsDelegationFromContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(nlParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(nlParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concrete}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcrete(nlParser.ConcreteContext ctx);
}