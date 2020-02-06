// Generated from nl.g4 by ANTLR 4.7.1
package eu.lightest.gtpl.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class nlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, ID=20, CONC=21, NUM=22, WHITESPACE=23, COMMENT=24;
	public static final int
		RULE_nl = 0, RULE_policyrules = 1, RULE_inputformat = 2, RULE_concreteformat = 3, 
		RULE_constraints = 4, RULE_attribute = 5, RULE_conditional = 6, RULE_value = 7;
	public static final String[] ruleNames = {
		"nl", "policyrules", "inputformat", "concreteformat", "constraints", "attribute", 
		"conditional", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'is'", "'format'", "'of'", "'then'", "'accept'", "'it'", 
		"';'", "','", "'and'", "'.'", "'equals'", "'does not equal'", "'less than'", 
		"'less than or equal to'", "'greater than'", "'greater than or equal to'", 
		"'is equivalent to'", "'is from'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "ID", "CONC", "NUM", "WHITESPACE", 
		"COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "nl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public nlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NlContext extends ParserRuleContext {
		public PolicyrulesContext policyrules() {
			return getRuleContext(PolicyrulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(nlParser.EOF, 0); }
		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterNl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitNl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_nl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			policyrules();
			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolicyrulesContext extends ParserRuleContext {
		public PolicyrulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policyrules; }
	 
		public PolicyrulesContext() { }
		public void copyFrom(PolicyrulesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PolicyRuleContext extends PolicyrulesContext {
		public List<InputformatContext> inputformat() {
			return getRuleContexts(InputformatContext.class);
		}
		public InputformatContext inputformat(int i) {
			return getRuleContext(InputformatContext.class,i);
		}
		public List<ConcreteformatContext> concreteformat() {
			return getRuleContexts(ConcreteformatContext.class);
		}
		public ConcreteformatContext concreteformat(int i) {
			return getRuleContext(ConcreteformatContext.class,i);
		}
		public List<ConstraintsContext> constraints() {
			return getRuleContexts(ConstraintsContext.class);
		}
		public ConstraintsContext constraints(int i) {
			return getRuleContext(ConstraintsContext.class,i);
		}
		public PolicyRuleContext(PolicyrulesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterPolicyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitPolicyRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitPolicyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolicyrulesContext policyrules() throws RecognitionException {
		PolicyrulesContext _localctx = new PolicyrulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_policyrules);
		int _la;
		try {
			_localctx = new PolicyRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(19);
				match(T__0);
				setState(20);
				inputformat();
				setState(21);
				match(T__1);
				setState(22);
				match(T__2);
				setState(23);
				match(T__3);
				setState(24);
				concreteformat();
				setState(25);
				constraints();
				setState(26);
				match(T__4);
				setState(27);
				match(T__5);
				setState(28);
				match(T__6);
				setState(29);
				match(T__7);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputformatContext extends ParserRuleContext {
		public InputformatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputformat; }
	 
		public InputformatContext() { }
		public void copyFrom(InputformatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InputContext extends InputformatContext {
		public TerminalNode CONC() { return getToken(nlParser.CONC, 0); }
		public InputContext(InputformatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputformatContext inputformat() throws RecognitionException {
		InputformatContext _localctx = new InputformatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inputformat);
		try {
			_localctx = new InputContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(CONC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConcreteformatContext extends ParserRuleContext {
		public ConcreteformatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concreteformat; }
	 
		public ConcreteformatContext() { }
		public void copyFrom(ConcreteformatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormatNameContext extends ConcreteformatContext {
		public TerminalNode CONC() { return getToken(nlParser.CONC, 0); }
		public FormatNameContext(ConcreteformatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterFormatName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitFormatName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitFormatName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcreteformatContext concreteformat() throws RecognitionException {
		ConcreteformatContext _localctx = new ConcreteformatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_concreteformat);
		try {
			_localctx = new FormatNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(CONC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintsContext extends ParserRuleContext {
		public ConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraints; }
	 
		public ConstraintsContext() { }
		public void copyFrom(ConstraintsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstraintContext extends ConstraintsContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ConditionalContext> conditional() {
			return getRuleContexts(ConditionalContext.class);
		}
		public ConditionalContext conditional(int i) {
			return getRuleContext(ConditionalContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ConstraintContext(ConstraintsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintsContext constraints() throws RecognitionException {
		ConstraintsContext _localctx = new ConstraintsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constraints);
		int _la;
		try {
			_localctx = new ConstraintContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << CONC))) != 0)) {
				{
				{
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(40);
					match(T__8);
					}
				}

				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(43);
					match(T__9);
					}
				}

				setState(46);
				attribute();
				setState(47);
				conditional();
				setState(48);
				value();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeNameContext extends AttributeContext {
		public List<TerminalNode> CONC() { return getTokens(nlParser.CONC); }
		public TerminalNode CONC(int i) {
			return getToken(nlParser.CONC, i);
		}
		public AttributeNameContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitAttributeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitAttributeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attribute);
		int _la;
		try {
			_localctx = new AttributeNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(CONC);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(56);
				match(T__10);
				setState(57);
				match(CONC);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	 
		public ConditionalContext() { }
		public void copyFrom(ConditionalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualsContext extends ConditionalContext {
		public EqualsContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ConditionalContext {
		public LessThanContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualContext extends ConditionalContext {
		public NotEqualContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanOrEqualContext extends ConditionalContext {
		public LessThanOrEqualContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterLessThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitLessThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitLessThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends ConditionalContext {
		public GreaterThanContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsEquivalentContext extends ConditionalContext {
		public IsEquivalentContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterIsEquivalent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitIsEquivalent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitIsEquivalent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsDelegationFromContext extends ConditionalContext {
		public IsDelegationFromContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterIsDelegationFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitIsDelegationFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitIsDelegationFrom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsContext extends ConditionalContext {
		public IsContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanOrEqualContext extends ConditionalContext {
		public GreaterThanOrEqualContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterGreaterThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitGreaterThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitGreaterThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_conditional);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new NotEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new LessThanOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(T__14);
				}
				break;
			case T__15:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				match(T__15);
				}
				break;
			case T__16:
				_localctx = new GreaterThanOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				match(T__16);
				}
				break;
			case T__1:
				_localctx = new IsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(69);
				match(T__1);
				}
				break;
			case T__17:
				_localctx = new IsEquivalentContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(70);
				match(T__17);
				}
				break;
			case T__18:
				_localctx = new IsDelegationFromContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(71);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableContext extends ValueContext {
		public TerminalNode ID() { return getToken(nlParser.ID, 0); }
		public VariableContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ValueContext {
		public TerminalNode NUM() { return getToken(nlParser.NUM, 0); }
		public NumberContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcreteContext extends ValueContext {
		public TerminalNode CONC() { return getToken(nlParser.CONC, 0); }
		public ConcreteContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).enterConcrete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nlListener ) ((nlListener)listener).exitConcrete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nlVisitor ) return ((nlVisitor<? extends T>)visitor).visitConcrete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(NUM);
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(ID);
				}
				break;
			case CONC:
				_localctx = new ConcreteContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(CONC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32R\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13\3\3\4"+
		"\3\4\3\5\3\5\3\6\5\6,\n\6\3\6\5\6/\n\6\3\6\3\6\3\6\3\6\7\6\65\n\6\f\6"+
		"\16\68\13\6\3\7\3\7\3\7\7\7=\n\7\f\7\16\7@\13\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\5\tP\n\t\3\t\2\2\n\2\4\6\b\n\f\16"+
		"\20\2\2\2X\2\22\3\2\2\2\4#\3\2\2\2\6&\3\2\2\2\b(\3\2\2\2\n\66\3\2\2\2"+
		"\f9\3\2\2\2\16J\3\2\2\2\20O\3\2\2\2\22\23\5\4\3\2\23\24\7\2\2\3\24\3\3"+
		"\2\2\2\25\26\7\3\2\2\26\27\5\6\4\2\27\30\7\4\2\2\30\31\7\5\2\2\31\32\7"+
		"\6\2\2\32\33\5\b\5\2\33\34\5\n\6\2\34\35\7\7\2\2\35\36\7\b\2\2\36\37\7"+
		"\t\2\2\37 \7\n\2\2 \"\3\2\2\2!\25\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2"+
		"\2$\5\3\2\2\2%#\3\2\2\2&\'\7\27\2\2\'\7\3\2\2\2()\7\27\2\2)\t\3\2\2\2"+
		"*,\7\13\2\2+*\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\7\f\2\2.-\3\2\2\2./\3\2\2"+
		"\2/\60\3\2\2\2\60\61\5\f\7\2\61\62\5\16\b\2\62\63\5\20\t\2\63\65\3\2\2"+
		"\2\64+\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\13\3\2\2\28"+
		"\66\3\2\2\29>\7\27\2\2:;\7\r\2\2;=\7\27\2\2<:\3\2\2\2=@\3\2\2\2><\3\2"+
		"\2\2>?\3\2\2\2?\r\3\2\2\2@>\3\2\2\2AK\7\16\2\2BK\7\17\2\2CK\7\20\2\2D"+
		"K\7\21\2\2EK\7\22\2\2FK\7\23\2\2GK\7\4\2\2HK\7\24\2\2IK\7\25\2\2JA\3\2"+
		"\2\2JB\3\2\2\2JC\3\2\2\2JD\3\2\2\2JE\3\2\2\2JF\3\2\2\2JG\3\2\2\2JH\3\2"+
		"\2\2JI\3\2\2\2K\17\3\2\2\2LP\7\30\2\2MP\7\26\2\2NP\7\27\2\2OL\3\2\2\2"+
		"OM\3\2\2\2ON\3\2\2\2P\21\3\2\2\2\t#+.\66>JO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}