// Generated from nl.g4 by ANTLR 4.7.1
package eu.lightest.gtpl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class nlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, ID=20, CONC=21, NUM=22, WHITESPACE=23, COMMENT=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "ID", "CONC", "NUM", "WHITESPACE", "COMMENT"
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


	public nlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "nl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00fa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7"+
		"\25\u00d5\n\25\f\25\16\25\u00d8\13\25\3\26\3\26\7\26\u00dc\n\26\f\26\16"+
		"\26\u00df\13\26\3\27\3\27\7\27\u00e3\n\27\f\27\16\27\u00e6\13\27\3\30"+
		"\6\30\u00e9\n\30\r\30\16\30\u00ea\3\30\3\30\3\31\3\31\3\31\3\31\6\31\u00f3"+
		"\n\31\r\31\16\31\u00f4\3\31\3\31\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\3\2\6\6\2\62;C\\aac|\4\2C\\c|\5\2\13\f\17\17\""+
		"\"\3\2\f\f\2\u00fe\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\66\3\2\2\2\79\3\2\2\2\t"+
		"@\3\2\2\2\13C\3\2\2\2\rH\3\2\2\2\17O\3\2\2\2\21R\3\2\2\2\23T\3\2\2\2\25"+
		"V\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33c\3\2\2\2\35r\3\2\2\2\37|\3\2\2\2"+
		"!\u0092\3\2\2\2#\u009f\3\2\2\2%\u00b8\3\2\2\2\'\u00c9\3\2\2\2)\u00d1\3"+
		"\2\2\2+\u00d9\3\2\2\2-\u00e0\3\2\2\2/\u00e8\3\2\2\2\61\u00ee\3\2\2\2\63"+
		"\64\7k\2\2\64\65\7h\2\2\65\4\3\2\2\2\66\67\7k\2\2\678\7u\2\28\6\3\2\2"+
		"\29:\7h\2\2:;\7q\2\2;<\7t\2\2<=\7o\2\2=>\7c\2\2>?\7v\2\2?\b\3\2\2\2@A"+
		"\7q\2\2AB\7h\2\2B\n\3\2\2\2CD\7v\2\2DE\7j\2\2EF\7g\2\2FG\7p\2\2G\f\3\2"+
		"\2\2HI\7c\2\2IJ\7e\2\2JK\7e\2\2KL\7g\2\2LM\7r\2\2MN\7v\2\2N\16\3\2\2\2"+
		"OP\7k\2\2PQ\7v\2\2Q\20\3\2\2\2RS\7=\2\2S\22\3\2\2\2TU\7.\2\2U\24\3\2\2"+
		"\2VW\7c\2\2WX\7p\2\2XY\7f\2\2Y\26\3\2\2\2Z[\7\60\2\2[\30\3\2\2\2\\]\7"+
		"g\2\2]^\7s\2\2^_\7w\2\2_`\7c\2\2`a\7n\2\2ab\7u\2\2b\32\3\2\2\2cd\7f\2"+
		"\2de\7q\2\2ef\7g\2\2fg\7u\2\2gh\7\"\2\2hi\7p\2\2ij\7q\2\2jk\7v\2\2kl\7"+
		"\"\2\2lm\7g\2\2mn\7s\2\2no\7w\2\2op\7c\2\2pq\7n\2\2q\34\3\2\2\2rs\7n\2"+
		"\2st\7g\2\2tu\7u\2\2uv\7u\2\2vw\7\"\2\2wx\7v\2\2xy\7j\2\2yz\7c\2\2z{\7"+
		"p\2\2{\36\3\2\2\2|}\7n\2\2}~\7g\2\2~\177\7u\2\2\177\u0080\7u\2\2\u0080"+
		"\u0081\7\"\2\2\u0081\u0082\7v\2\2\u0082\u0083\7j\2\2\u0083\u0084\7c\2"+
		"\2\u0084\u0085\7p\2\2\u0085\u0086\7\"\2\2\u0086\u0087\7q\2\2\u0087\u0088"+
		"\7t\2\2\u0088\u0089\7\"\2\2\u0089\u008a\7g\2\2\u008a\u008b\7s\2\2\u008b"+
		"\u008c\7w\2\2\u008c\u008d\7c\2\2\u008d\u008e\7n\2\2\u008e\u008f\7\"\2"+
		"\2\u008f\u0090\7v\2\2\u0090\u0091\7q\2\2\u0091 \3\2\2\2\u0092\u0093\7"+
		"i\2\2\u0093\u0094\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7c\2\2\u0096\u0097"+
		"\7v\2\2\u0097\u0098\7g\2\2\u0098\u0099\7t\2\2\u0099\u009a\7\"\2\2\u009a"+
		"\u009b\7v\2\2\u009b\u009c\7j\2\2\u009c\u009d\7c\2\2\u009d\u009e\7p\2\2"+
		"\u009e\"\3\2\2\2\u009f\u00a0\7i\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g"+
		"\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6"+
		"\7t\2\2\u00a6\u00a7\7\"\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7j\2\2\u00a9"+
		"\u00aa\7c\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7\"\2\2\u00ac\u00ad\7q\2"+
		"\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1"+
		"\7s\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4"+
		"\u00b5\7\"\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7q\2\2\u00b7$\3\2\2\2\u00b8"+
		"\u00b9\7k\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7\"\2\2\u00bb\u00bc\7g\2"+
		"\2\u00bc\u00bd\7s\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0"+
		"\7x\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\u00c4\7p\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00c7\7v\2"+
		"\2\u00c7\u00c8\7q\2\2\u00c8&\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7"+
		"u\2\2\u00cb\u00cc\7\"\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7t\2\2\u00ce"+
		"\u00cf\7q\2\2\u00cf\u00d0\7o\2\2\u00d0(\3\2\2\2\u00d1\u00d2\7A\2\2\u00d2"+
		"\u00d6\4C\\\2\u00d3\u00d5\t\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7*\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00dd\t\3\2\2\u00da\u00dc\t\2\2\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de,\3\2\2\2"+
		"\u00df\u00dd\3\2\2\2\u00e0\u00e4\4\63;\2\u00e1\u00e3\4\62;\2\u00e2\u00e1"+
		"\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		".\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\t\4\2\2\u00e8\u00e7\3\2\2\2"+
		"\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ed\b\30\2\2\u00ed\60\3\2\2\2\u00ee\u00ef\7\61\2\2\u00ef"+
		"\u00f0\7\61\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00f3\n\5\2\2\u00f2\u00f1\3"+
		"\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\7\f\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\b\31"+
		"\2\2\u00f9\62\3\2\2\2\b\2\u00d6\u00dd\u00e4\u00ea\u00f4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}