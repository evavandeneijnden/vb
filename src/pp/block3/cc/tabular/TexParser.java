// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/block3/cc/tabular/Tex.g4 by ANTLR 4.5
package pp.block3.cc.symbol;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TexParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, LEFT=6, CENTERED=7, RIGHT=8, ENTRY=9, 
		COMMENT=10, WS=11;
	public static final int
		RULE_table = 0, RULE_beginTable = 1, RULE_argument = 2, RULE_row = 3, 
		RULE_endTable = 4;
	public static final String[] ruleNames = {
		"table", "beginTable", "argument", "row", "endTable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\begin{tabular}{'", "'}'", "'&'", "'\\\\'", "'\\end{tabular}'", 
		"'l'", "'c'", "'r'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "LEFT", "CENTERED", "RIGHT", "ENTRY", 
		"COMMENT", "WS"
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

	@Override
	public String getGrammarFileName() { return "Tex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TableContext extends ParserRuleContext {
		public BeginTableContext beginTable() {
			return getRuleContext(BeginTableContext.class,0);
		}
		public EndTableContext endTable() {
			return getRuleContext(EndTableContext.class,0);
		}
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).exitTable(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); 
			beginTable();
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11); 
				row();
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ENTRY );
			setState(16); 
			endTable();
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

	public static class BeginTableContext extends ParserRuleContext {
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode WS() { return getToken(TexParser.WS, 0); }
		public BeginTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).enterBeginTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).exitBeginTable(this);
		}
	}

	public final BeginTableContext beginTable() throws RecognitionException {
		BeginTableContext _localctx = new BeginTableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_beginTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			match(T__0);
			setState(19); 
			argument();
			setState(20); 
			match(T__1);
			setState(21); 
			match(WS);
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

	public static class ArgumentContext extends ParserRuleContext {
		public List<TerminalNode> LEFT() { return getTokens(TexParser.LEFT); }
		public TerminalNode LEFT(int i) {
			return getToken(TexParser.LEFT, i);
		}
		public List<TerminalNode> CENTERED() { return getTokens(TexParser.CENTERED); }
		public TerminalNode CENTERED(int i) {
			return getToken(TexParser.CENTERED, i);
		}
		public List<TerminalNode> RIGHT() { return getTokens(TexParser.RIGHT); }
		public TerminalNode RIGHT(int i) {
			return getToken(TexParser.RIGHT, i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << CENTERED) | (1L << RIGHT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << CENTERED) | (1L << RIGHT))) != 0) );
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

	public static class RowContext extends ParserRuleContext {
		public List<TerminalNode> ENTRY() { return getTokens(TexParser.ENTRY); }
		public TerminalNode ENTRY(int i) {
			return getToken(TexParser.ENTRY, i);
		}
		public List<TerminalNode> WS() { return getTokens(TexParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(TexParser.WS, i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).exitRow(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			match(ENTRY);
			setState(29); 
			match(WS);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(30); 
				match(T__2);
				setState(31); 
				match(WS);
				setState(32); 
				match(ENTRY);
				setState(33); 
				match(WS);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); 
			match(T__3);
			setState(40); 
			match(WS);
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

	public static class EndTableContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(TexParser.WS, 0); }
		public EndTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).enterEndTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TexListener ) ((TexListener)listener).exitEndTable(this);
		}
	}

	public final EndTableContext endTable() throws RecognitionException {
		EndTableContext _localctx = new EndTableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_endTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); 
			match(T__4);
			setState(43); 
			match(WS);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\60\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\6\2\17\n\2\r\2\16\2\20\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\6\4\33\n\4\r\4\16\4\34\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5%\n\5\f\5\16\5(\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2"+
		"\3\3\2\b\n-\2\f\3\2\2\2\4\24\3\2\2\2\6\32\3\2\2\2\b\36\3\2\2\2\n,\3\2"+
		"\2\2\f\16\5\4\3\2\r\17\5\b\5\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2"+
		"\2\20\21\3\2\2\2\21\22\3\2\2\2\22\23\5\n\6\2\23\3\3\2\2\2\24\25\7\3\2"+
		"\2\25\26\5\6\4\2\26\27\7\4\2\2\27\30\7\r\2\2\30\5\3\2\2\2\31\33\t\2\2"+
		"\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\7\3\2\2"+
		"\2\36\37\7\13\2\2\37&\7\r\2\2 !\7\5\2\2!\"\7\r\2\2\"#\7\13\2\2#%\7\r\2"+
		"\2$ \3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\6"+
		"\2\2*+\7\r\2\2+\t\3\2\2\2,-\7\7\2\2-.\7\r\2\2.\13\3\2\2\2\5\20\34&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}