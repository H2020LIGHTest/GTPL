// Generated from nl.g4 by ANTLR 4.7.1
package eu.lightest.gtpl.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link nlParser}.
 */
public interface nlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link nlParser#nl}.
	 * @param ctx the parse tree
	 */
	void enterNl(nlParser.NlContext ctx);
	/**
	 * Exit a parse tree produced by {@link nlParser#nl}.
	 * @param ctx the parse tree
	 */
	void exitNl(nlParser.NlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PolicyRule}
	 * labeled alternative in {@link nlParser#policyrules}.
	 * @param ctx the parse tree
	 */
	void enterPolicyRule(nlParser.PolicyRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PolicyRule}
	 * labeled alternative in {@link nlParser#policyrules}.
	 * @param ctx the parse tree
	 */
	void exitPolicyRule(nlParser.PolicyRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Input}
	 * labeled alternative in {@link nlParser#inputformat}.
	 * @param ctx the parse tree
	 */
	void enterInput(nlParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Input}
	 * labeled alternative in {@link nlParser#inputformat}.
	 * @param ctx the parse tree
	 */
	void exitInput(nlParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FormatName}
	 * labeled alternative in {@link nlParser#concreteformat}.
	 * @param ctx the parse tree
	 */
	void enterFormatName(nlParser.FormatNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FormatName}
	 * labeled alternative in {@link nlParser#concreteformat}.
	 * @param ctx the parse tree
	 */
	void exitFormatName(nlParser.FormatNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constraint}
	 * labeled alternative in {@link nlParser#constraints}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(nlParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constraint}
	 * labeled alternative in {@link nlParser#constraints}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(nlParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link nlParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttributeName(nlParser.AttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeName}
	 * labeled alternative in {@link nlParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttributeName(nlParser.AttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterEquals(nlParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitEquals(nlParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(nlParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(nlParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(nlParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(nlParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqual(nlParser.LessThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanOrEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqual(nlParser.LessThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(nlParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(nlParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqual(nlParser.GreaterThanOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanOrEqual}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqual(nlParser.GreaterThanOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Is}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterIs(nlParser.IsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitIs(nlParser.IsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsEquivalent}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterIsEquivalent(nlParser.IsEquivalentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsEquivalent}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitIsEquivalent(nlParser.IsEquivalentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsDelegationFrom}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterIsDelegationFrom(nlParser.IsDelegationFromContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsDelegationFrom}
	 * labeled alternative in {@link nlParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitIsDelegationFrom(nlParser.IsDelegationFromContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumber(nlParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumber(nlParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVariable(nlParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVariable(nlParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concrete}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterConcrete(nlParser.ConcreteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concrete}
	 * labeled alternative in {@link nlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitConcrete(nlParser.ConcreteContext ctx);
}