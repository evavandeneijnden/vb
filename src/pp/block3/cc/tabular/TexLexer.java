// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/block3/cc/tabular/Tex.g4 by ANTLR 4.5
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ARGUMENT=6, ENTRY=7, COMMENT=8, 
		WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "ARGUMENT", "ENTRY", "COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\begin{tabular}{'", "'}'", "'&'", "'\\\\'", "'\\end{tabular}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ARGUMENT", "ENTRY", "COMMENT", "WS"
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


	public TexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13Y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\6\7=\n\7\r\7\16\7>\3\b\7\bB\n\b\f\b\16\bE\13\b\3\t\3\t\7\tI\n"+
		"\t\f\t\16\tL\13\t\3\t\6\tO\n\t\r\t\16\tP\3\t\3\t\3\n\6\nV\n\n\r\n\16\n"+
		"W\3J\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\5\2eenntt\5\2"+
		"\62;C\\c|\4\2\f\f\17\17\5\2\13\f\17\17\"\"]\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5&\3\2\2\2\7(\3\2\2\2\t*\3\2\2\2\13-\3"+
		"\2\2\2\r<\3\2\2\2\17C\3\2\2\2\21F\3\2\2\2\23U\3\2\2\2\25\26\7^\2\2\26"+
		"\27\7d\2\2\27\30\7g\2\2\30\31\7i\2\2\31\32\7k\2\2\32\33\7p\2\2\33\34\7"+
		"}\2\2\34\35\7v\2\2\35\36\7c\2\2\36\37\7d\2\2\37 \7w\2\2 !\7n\2\2!\"\7"+
		"c\2\2\"#\7t\2\2#$\7\177\2\2$%\7}\2\2%\4\3\2\2\2&\'\7\177\2\2\'\6\3\2\2"+
		"\2()\7(\2\2)\b\3\2\2\2*+\7^\2\2+,\7^\2\2,\n\3\2\2\2-.\7^\2\2./\7g\2\2"+
		"/\60\7p\2\2\60\61\7f\2\2\61\62\7}\2\2\62\63\7v\2\2\63\64\7c\2\2\64\65"+
		"\7d\2\2\65\66\7w\2\2\66\67\7n\2\2\678\7c\2\289\7t\2\29:\7\177\2\2:\f\3"+
		"\2\2\2;=\t\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\16\3\2\2\2@"+
		"B\t\3\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\20\3\2\2\2EC\3\2\2"+
		"\2FJ\7\'\2\2GI\13\2\2\2HG\3\2\2\2IL\3\2\2\2JK\3\2\2\2JH\3\2\2\2KN\3\2"+
		"\2\2LJ\3\2\2\2MO\t\4\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2"+
		"\2\2RS\b\t\2\2S\22\3\2\2\2TV\t\5\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3"+
		"\2\2\2X\24\3\2\2\2\b\2>CJPW\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}