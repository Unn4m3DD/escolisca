// Generated from C:/Users/guerr/IdeaProjects/LFA/src/test\int..g4 by ANTLR 4.8
package test;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class intLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBER", "INT", "EXP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public intLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "int..g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\3.\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\5\2\13\n\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\2\5\2\24\n"+
		"\2\3\2\3\2\3\2\3\2\5\2\32\n\2\3\2\5\2\35\n\2\3\3\3\3\3\3\7\3\"\n\3\f\3"+
		"\16\3%\13\3\5\3\'\n\3\3\4\3\4\5\4+\n\4\3\4\3\4\2\2\5\3\3\5\2\7\2\3\2\6"+
		"\3\2\63;\3\2\62;\4\2GGgg\4\2--//\2\64\2\3\3\2\2\2\3\34\3\2\2\2\5&\3\2"+
		"\2\2\7(\3\2\2\2\t\13\7/\2\2\n\t\3\2\2\2\n\13\3\2\2\2\13\f\3\2\2\2\f\r"+
		"\5\5\3\2\r\16\7\60\2\2\16\20\5\5\3\2\17\21\5\7\4\2\20\17\3\2\2\2\20\21"+
		"\3\2\2\2\21\35\3\2\2\2\22\24\7/\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24\25"+
		"\3\2\2\2\25\26\5\5\3\2\26\27\5\7\4\2\27\35\3\2\2\2\30\32\7/\2\2\31\30"+
		"\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\35\5\5\3\2\34\n\3\2\2\2\34\23"+
		"\3\2\2\2\34\31\3\2\2\2\35\4\3\2\2\2\36\'\7\62\2\2\37#\t\2\2\2 \"\t\3\2"+
		"\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\'\3\2\2\2%#\3\2\2\2&\36\3"+
		"\2\2\2&\37\3\2\2\2\'\6\3\2\2\2(*\t\4\2\2)+\t\5\2\2*)\3\2\2\2*+\3\2\2\2"+
		"+,\3\2\2\2,-\5\5\3\2-\b\3\2\2\2\13\2\n\20\23\31\34#&*\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}