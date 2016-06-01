// Generated from C:/Users/Eva/Documents/vb/block 3/src/pp/block3/cc/antlr/CC5\CC5Attr.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC5AttrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MINUS=1, POWER=2, LPAR=3, RPAR=4, EQUALS=5, BOOL=6, PLUS=7, STR=8, NUM=9, 
		WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"MINUS", "POWER", "LPAR", "RPAR", "EQUALS", "BOOL", "PLUS", "STR", "NUM", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-'", "'^'", "'('", "')'", "'=='", null, "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "MINUS", "POWER", "LPAR", "RPAR", "EQUALS", "BOOL", "PLUS", "STR", 
		"NUM", "WS"
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


	    private int getValue(String text) {
	        return Integer.parseInt(text);
	    }


	public CC5AttrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CC5Attr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f=\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7,\n\7\3\b\3\b\3\t\6\t\61\n\t\r\t\16\t\62\3\n\6\n\66"+
		"\n\n\r\n\16\n\67\3\13\3\13\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\3\2\5\6\2\"\"C\\c|~~\3\2\62;\5\2\13\f\17\17\"\"?\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5"+
		"\31\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2\13\37\3\2\2\2\r+\3\2\2\2\17-\3\2"+
		"\2\2\21\60\3\2\2\2\23\65\3\2\2\2\259\3\2\2\2\27\30\7/\2\2\30\4\3\2\2\2"+
		"\31\32\7`\2\2\32\6\3\2\2\2\33\34\7*\2\2\34\b\3\2\2\2\35\36\7+\2\2\36\n"+
		"\3\2\2\2\37 \7?\2\2 !\7?\2\2!\f\3\2\2\2\"#\7h\2\2#$\7c\2\2$%\7n\2\2%&"+
		"\7u\2\2&,\7g\2\2\'(\7v\2\2()\7t\2\2)*\7w\2\2*,\7g\2\2+\"\3\2\2\2+\'\3"+
		"\2\2\2,\16\3\2\2\2-.\7-\2\2.\20\3\2\2\2/\61\t\2\2\2\60/\3\2\2\2\61\62"+
		"\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\22\3\2\2\2\64\66\t\3\2\2\65\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\24\3\2\2\29:\t\4\2\2"+
		":;\3\2\2\2;<\b\13\2\2<\26\3\2\2\2\6\2+\62\67\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}