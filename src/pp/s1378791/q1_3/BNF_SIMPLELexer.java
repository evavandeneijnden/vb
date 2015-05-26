// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/s1378791/q1_3/BNF_SIMPLE.g4 by ANTLR 4.5
package pp.s1378791.q1_3;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BNF_SIMPLELexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUM=1, ID=2, PLS=3, MNS=4, LP=5, RP=6, LBRACK=7, RBRACK=8, POINT=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NUM", "ID", "PLS", "MNS", "LP", "RP", "LBRACK", "RBRACK", "POINT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'+'", "'-'", "'('", "')'", "'['", "']'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUM", "ID", "PLS", "MNS", "LP", "RP", "LBRACK", "RBRACK", "POINT"
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


	public BNF_SIMPLELexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BNF_SIMPLE.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13-\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2"+
		"\27\n\2\r\2\16\2\30\3\3\6\3\34\n\3\r\3\16\3\35\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\3\2\4\3\2\62;\5\2\62;C\\c|.\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\3\26\3\2\2\2\5\33\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#\3"+
		"\2\2\2\r%\3\2\2\2\17\'\3\2\2\2\21)\3\2\2\2\23+\3\2\2\2\25\27\t\2\2\2\26"+
		"\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\4\3\2\2\2\32"+
		"\34\t\3\2\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36"+
		"\6\3\2\2\2\37 \7-\2\2 \b\3\2\2\2!\"\7/\2\2\"\n\3\2\2\2#$\7*\2\2$\f\3\2"+
		"\2\2%&\7+\2\2&\16\3\2\2\2\'(\7]\2\2(\20\3\2\2\2)*\7_\2\2*\22\3\2\2\2+"+
		",\7\60\2\2,\24\3\2\2\2\5\2\30\35\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}