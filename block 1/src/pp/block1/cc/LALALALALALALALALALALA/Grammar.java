// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/block1/cc/LALALALALALALALALALALA/Grammar.g4 by ANTLR 4.5
package pp.block1.cc.LALALALALALALALALALALA;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Grammar extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LA=1, LALA=2, LALALALI=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LA", "LI", "LALA", "LALALALI"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LA", "LALA", "LALALALI"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Grammar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5(\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\6\2\16\n\2\r\2\16\2\17\3\2\7\2\23\n\2\f"+
		"\2\16\2\26\13\2\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\2\2\6\3\3\5\2\7\4\t\5\3\2\2)\2\3\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\3\13\3\2\2\2\5\27\3\2\2\2\7 \3\2\2\2\t#\3\2\2\2\13"+
		"\r\7N\2\2\f\16\7c\2\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2"+
		"\2\2\20\24\3\2\2\2\21\23\7\"\2\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2"+
		"\2\2\24\25\3\2\2\2\25\4\3\2\2\2\26\24\3\2\2\2\27\30\7N\2\2\30\31\7k\2"+
		"\2\31\35\3\2\2\2\32\34\7\"\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2"+
		"\2\35\36\3\2\2\2\36\6\3\2\2\2\37\35\3\2\2\2 !\5\3\2\2!\"\5\3\2\2\"\b\3"+
		"\2\2\2#$\5\3\2\2$%\5\3\2\2%&\5\3\2\2&\'\5\5\3\2\'\n\3\2\2\2\6\2\17\24"+
		"\35\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}