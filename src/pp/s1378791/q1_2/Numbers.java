// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/s1378791/q1_2/Numbers.g4 by ANTLR 4.5
package pp.s1378791.q1_2;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Numbers extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LONG_BINARY=1, LONG_OCTAL=2, LONG_DECIMAL=3, LONG_HEXADECIMAL=4, INT_BINARY=5, 
		INT_OCTAL=6, INT_DECIMAL=7, INT_HEXADECIMAL=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LONG_BINARY", "LONG_OCTAL", "LONG_DECIMAL", "LONG_HEXADECIMAL", "INT_BINARY", 
		"INT_OCTAL", "INT_DECIMAL", "INT_HEXADECIMAL", "LONG", "BIT", "OCT", "INT", 
		"HEX", "ZERO", "X", "B"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LONG_BINARY", "LONG_OCTAL", "LONG_DECIMAL", "LONG_HEXADECIMAL", 
		"INT_BINARY", "INT_OCTAL", "INT_DECIMAL", "INT_HEXADECIMAL"
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


	public Numbers(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Numbers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n_\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7"+
		"\67\n\7\3\b\3\b\5\b;\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\6\13D\n\13\r\13"+
		"\16\13E\3\f\3\f\6\fJ\n\f\r\f\16\fK\3\r\3\r\7\rP\n\r\f\r\16\rS\13\r\3\16"+
		"\6\16V\n\16\r\16\16\16W\3\17\3\17\3\20\3\20\3\21\3\21\2\2\22\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2\3\2\t"+
		"\4\2NNnn\3\2\62\63\3\2\639\3\2\629\3\2\63;\3\2\62;\5\2\62;CHch\\\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\3#\3\2\2\2\5&\3\2\2\2\7)\3\2\2\2\t,\3\2\2\2\13"+
		"/\3\2\2\2\r\63\3\2\2\2\17:\3\2\2\2\21<\3\2\2\2\23@\3\2\2\2\25C\3\2\2\2"+
		"\27G\3\2\2\2\31M\3\2\2\2\33U\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!]\3\2\2\2"+
		"#$\5\13\6\2$%\5\23\n\2%\4\3\2\2\2&\'\5\r\7\2\'(\5\23\n\2(\6\3\2\2\2)*"+
		"\5\17\b\2*+\5\23\n\2+\b\3\2\2\2,-\5\21\t\2-.\5\23\n\2.\n\3\2\2\2/\60\5"+
		"\35\17\2\60\61\5!\21\2\61\62\5\25\13\2\62\f\3\2\2\2\63\66\5\35\17\2\64"+
		"\67\5\35\17\2\65\67\5\27\f\2\66\64\3\2\2\2\66\65\3\2\2\2\67\16\3\2\2\2"+
		"8;\5\35\17\29;\5\31\r\2:8\3\2\2\2:9\3\2\2\2;\20\3\2\2\2<=\5\35\17\2=>"+
		"\5\37\20\2>?\5\33\16\2?\22\3\2\2\2@A\t\2\2\2A\24\3\2\2\2BD\t\3\2\2CB\3"+
		"\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\26\3\2\2\2GI\t\4\2\2HJ\t\5\2\2I"+
		"H\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\30\3\2\2\2MQ\t\6\2\2NP\t\7\2"+
		"\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\32\3\2\2\2SQ\3\2\2\2TV\t\b"+
		"\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\34\3\2\2\2YZ\7\62\2\2Z\36"+
		"\3\2\2\2[\\\7z\2\2\\ \3\2\2\2]^\7d\2\2^\"\3\2\2\2\t\2\66:EKQW\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}