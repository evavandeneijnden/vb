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
		ARGUMENT=1, COMMENT=2, WS=3, BS=4, LB=5, RB=6, AND=7, TABULAR=8, BEGIN=9, 
		END=10, ENTRY=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ARGUMENT", "COMMENT", "WS", "BS", "LB", "RB", "AND", "TABULAR", "BEGIN", 
		"END", "ENTRY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'tabular'", "'begin'", 
		"'end'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ARGUMENT", "COMMENT", "WS", "BS", "LB", "RB", "AND", "TABULAR", 
		"BEGIN", "END", "ENTRY"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rU\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\6\2\33\n\2\r\2\16\2\34\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3"+
		"\3\3\6\3\'\n\3\r\3\16\3(\3\3\3\3\3\4\6\4.\n\4\r\4\16\4/\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\7\fN\n\f\f\f\16\fQ\13\f\3\f\5\fT\n\f"+
		"\3\"\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\13\5\2"+
		"eenntt\4\2\f\f\17\17\5\2\13\f\17\17\"\"\3\2^^\3\2}}\3\2\177\177\3\2(("+
		"\5\2\62;C\\c|\6\2\"\"\62;C\\c|Z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\32\3\2\2\2\5\36\3\2\2\2\7-\3\2\2\2\t"+
		"\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\219\3\2\2\2\23A\3"+
		"\2\2\2\25G\3\2\2\2\27K\3\2\2\2\31\33\t\2\2\2\32\31\3\2\2\2\33\34\3\2\2"+
		"\2\34\32\3\2\2\2\34\35\3\2\2\2\35\4\3\2\2\2\36\"\7\'\2\2\37!\13\2\2\2"+
		" \37\3\2\2\2!$\3\2\2\2\"#\3\2\2\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\'\t"+
		"\3\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\b\3\2\2+\6"+
		"\3\2\2\2,.\t\4\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\b\3\2"+
		"\2\2\61\62\t\5\2\2\62\n\3\2\2\2\63\64\t\6\2\2\64\f\3\2\2\2\65\66\t\7\2"+
		"\2\66\16\3\2\2\2\678\t\b\2\28\20\3\2\2\29:\7v\2\2:;\7c\2\2;<\7d\2\2<="+
		"\7w\2\2=>\7n\2\2>?\7c\2\2?@\7t\2\2@\22\3\2\2\2AB\7d\2\2BC\7g\2\2CD\7i"+
		"\2\2DE\7k\2\2EF\7p\2\2F\24\3\2\2\2GH\7g\2\2HI\7p\2\2IJ\7f\2\2J\26\3\2"+
		"\2\2KS\t\t\2\2LN\t\n\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2"+
		"\2\2QO\3\2\2\2RT\t\t\2\2SO\3\2\2\2ST\3\2\2\2T\30\3\2\2\2\t\2\34\"(/OS"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}