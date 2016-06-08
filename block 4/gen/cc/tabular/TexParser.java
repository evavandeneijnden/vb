// Generated from C:/Users/Eva/Documents/vb/block 4/src/cc/tabular\Tex.g4 by ANTLR 4.5.1
package cc.tabular;
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARGUMENT=1, COMMENT=2, WS=3, BS=4, LB=5, RB=6, AND=7, TABULAR=8, BEGIN=9, 
		END=10, ENTRY=11;
	public static final int
		RULE_table = 0, RULE_beginTable = 1, RULE_row = 2, RULE_endTable = 3;
	public static final String[] ruleNames = {
		"table", "beginTable", "row", "endTable"
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
		public List<TerminalNode> WS() { return getTokens(TexParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(TexParser.WS, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TexVisitor ) return ((TexVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_table);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(8);
				match(WS);
				}
			}

			setState(11);
			beginTable();
			setState(13); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(12);
					row();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(15); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(17);
			endTable();
			setState(19);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(18);
				match(WS);
				}
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

	public static class BeginTableContext extends ParserRuleContext {
		public TerminalNode BS() { return getToken(TexParser.BS, 0); }
		public TerminalNode BEGIN() { return getToken(TexParser.BEGIN, 0); }
		public List<TerminalNode> LB() { return getTokens(TexParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(TexParser.LB, i);
		}
		public TerminalNode TABULAR() { return getToken(TexParser.TABULAR, 0); }
		public List<TerminalNode> RB() { return getTokens(TexParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(TexParser.RB, i);
		}
		public TerminalNode ARGUMENT() { return getToken(TexParser.ARGUMENT, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TexVisitor ) return ((TexVisitor<? extends T>)visitor).visitBeginTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginTableContext beginTable() throws RecognitionException {
		BeginTableContext _localctx = new BeginTableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_beginTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(BS);
			setState(22);
			match(BEGIN);
			setState(23);
			match(LB);
			setState(24);
			match(TABULAR);
			setState(25);
			match(RB);
			setState(26);
			match(LB);
			setState(27);
			match(ARGUMENT);
			setState(28);
			match(RB);
			setState(29);
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

	public static class RowContext extends ParserRuleContext {
		public List<TerminalNode> BS() { return getTokens(TexParser.BS); }
		public TerminalNode BS(int i) {
			return getToken(TexParser.BS, i);
		}
		public List<TerminalNode> WS() { return getTokens(TexParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(TexParser.WS, i);
		}
		public List<TerminalNode> AND() { return getTokens(TexParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TexParser.AND, i);
		}
		public List<TerminalNode> ENTRY() { return getTokens(TexParser.ENTRY); }
		public TerminalNode ENTRY(int i) {
			return getToken(TexParser.ENTRY, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TexVisitor ) return ((TexVisitor<? extends T>)visitor).visitRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_row);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(31);
						match(WS);
						}
					}

					setState(38);
					_la = _input.LA(1);
					if (_la==ENTRY) {
						{
						setState(34);
						match(ENTRY);
						setState(36);
						_la = _input.LA(1);
						if (_la==WS) {
							{
							setState(35);
							match(WS);
							}
						}

						}
					}

					setState(40);
					match(AND);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(47);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(46);
				match(WS);
				}
			}

			setState(53);
			_la = _input.LA(1);
			if (_la==ENTRY) {
				{
				setState(49);
				match(ENTRY);
				setState(51);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(50);
					match(WS);
					}
				}

				}
			}

			setState(55);
			match(BS);
			setState(56);
			match(BS);
			setState(57);
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
		public TerminalNode BS() { return getToken(TexParser.BS, 0); }
		public TerminalNode END() { return getToken(TexParser.END, 0); }
		public TerminalNode LB() { return getToken(TexParser.LB, 0); }
		public TerminalNode TABULAR() { return getToken(TexParser.TABULAR, 0); }
		public TerminalNode RB() { return getToken(TexParser.RB, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TexVisitor ) return ((TexVisitor<? extends T>)visitor).visitEndTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndTableContext endTable() throws RecognitionException {
		EndTableContext _localctx = new EndTableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_endTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(BS);
			setState(60);
			match(END);
			setState(61);
			match(LB);
			setState(62);
			match(TABULAR);
			setState(63);
			match(RB);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\rD\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\5\2\f\n\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\2\3"+
		"\2\5\2\26\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\5\4#\n\4\3\4"+
		"\3\4\5\4\'\n\4\5\4)\n\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\5\4\62\n\4\3\4"+
		"\3\4\5\4\66\n\4\5\48\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\2"+
		"\2\6\2\4\6\b\2\2I\2\13\3\2\2\2\4\27\3\2\2\2\6-\3\2\2\2\b=\3\2\2\2\n\f"+
		"\7\5\2\2\13\n\3\2\2\2\13\f\3\2\2\2\f\r\3\2\2\2\r\17\5\4\3\2\16\20\5\6"+
		"\4\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\23\3\2"+
		"\2\2\23\25\5\b\5\2\24\26\7\5\2\2\25\24\3\2\2\2\25\26\3\2\2\2\26\3\3\2"+
		"\2\2\27\30\7\6\2\2\30\31\7\13\2\2\31\32\7\7\2\2\32\33\7\n\2\2\33\34\7"+
		"\b\2\2\34\35\7\7\2\2\35\36\7\3\2\2\36\37\7\b\2\2\37 \7\5\2\2 \5\3\2\2"+
		"\2!#\7\5\2\2\"!\3\2\2\2\"#\3\2\2\2#(\3\2\2\2$&\7\r\2\2%\'\7\5\2\2&%\3"+
		"\2\2\2&\'\3\2\2\2\')\3\2\2\2($\3\2\2\2()\3\2\2\2)*\3\2\2\2*,\7\t\2\2+"+
		"\"\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\61\3\2\2\2/-\3\2\2\2\60\62\7"+
		"\5\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62\67\3\2\2\2\63\65\7\r\2\2\64\66\7"+
		"\5\2\2\65\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\63\3\2\2\2\678\3\2\2"+
		"\289\3\2\2\29:\7\6\2\2:;\7\6\2\2;<\7\5\2\2<\7\3\2\2\2=>\7\6\2\2>?\7\f"+
		"\2\2?@\7\7\2\2@A\7\n\2\2AB\7\b\2\2B\t\3\2\2\2\f\13\21\25\"&(-\61\65\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}