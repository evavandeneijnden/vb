// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/s1378791/q1_3/BNF_SIMPLE.g4 by ANTLR 4.5
package pp.s1378791.q1_3;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BNF_SIMPLEParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUM=1, ID=2, PLS=3, MNS=4, LP=5, RP=6, LBRACK=7, RBRACK=8, POINT=9;
	public static final int
		RULE_e = 0, RULE_f = 1, RULE_fh = 2, RULE_g = 3, RULE_gh = 4, RULE_a = 5;
	public static final String[] ruleNames = {
		"e", "f", "fh", "g", "gh", "a"
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

	@Override
	public String getGrammarFileName() { return "BNF_SIMPLE.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BNF_SIMPLEParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode PLS() { return getToken(BNF_SIMPLEParser.PLS, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode MNS() { return getToken(BNF_SIMPLEParser.MNS, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_e);
		try {
			setState(20);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12); 
				f();
				setState(13); 
				match(PLS);
				setState(14); 
				e();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(16); 
				f();
				setState(17); 
				match(MNS);
				setState(18); 
				e();
				}
				break;
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

	public static class FContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(BNF_SIMPLEParser.LP, 0); }
		public FhContext fh() {
			return getRuleContext(FhContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).exitF(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_f);
		try {
			setState(25);
			switch (_input.LA(1)) {
			case LP:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); 
				match(LP);
				setState(23); 
				fh();
				}
				break;
			case NUM:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(24); 
				g();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FhContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BNF_SIMPLEParser.ID, 0); }
		public TerminalNode RP() { return getToken(BNF_SIMPLEParser.RP, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public FhContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).enterFh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).exitFh(this);
		}
	}

	public final FhContext fh() throws RecognitionException {
		FhContext _localctx = new FhContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fh);
		try {
			setState(33);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); 
				match(ID);
				setState(28); 
				match(RP);
				setState(29); 
				f();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30); 
				e();
				setState(31); 
				match(RP);
				}
				break;
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

	public static class GContext extends ParserRuleContext {
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public GhContext gh() {
			return getRuleContext(GhContext.class,0);
		}
		public GContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).enterG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).exitG(this);
		}
	}

	public final GContext g() throws RecognitionException {
		GContext _localctx = new GContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_g);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			a();
			setState(36); 
			gh();
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

	public static class GhContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(BNF_SIMPLEParser.LBRACK, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(BNF_SIMPLEParser.RBRACK, 0); }
		public GhContext gh() {
			return getRuleContext(GhContext.class,0);
		}
		public TerminalNode POINT() { return getToken(BNF_SIMPLEParser.POINT, 0); }
		public TerminalNode ID() { return getToken(BNF_SIMPLEParser.ID, 0); }
		public GhContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).enterGh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).exitGh(this);
		}
	}

	public final GhContext gh() throws RecognitionException {
		GhContext _localctx = new GhContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gh);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case LBRACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); 
				match(LBRACK);
				setState(39); 
				e();
				setState(40); 
				match(RBRACK);
				setState(41); 
				gh();
				}
				break;
			case POINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); 
				match(POINT);
				setState(44); 
				match(ID);
				setState(45); 
				gh();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(BNF_SIMPLEParser.NUM, 0); }
		public TerminalNode ID() { return getToken(BNF_SIMPLEParser.ID, 0); }
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BNF_SIMPLEListener ) ((BNF_SIMPLEListener)listener).exitA(this);
		}
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_a);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5"+
		"\2\27\n\2\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\61\n\6\3\7\3\7\3\7\2\2\b"+
		"\2\4\6\b\n\f\2\3\3\2\3\4\62\2\26\3\2\2\2\4\33\3\2\2\2\6#\3\2\2\2\b%\3"+
		"\2\2\2\n\60\3\2\2\2\f\62\3\2\2\2\16\17\5\4\3\2\17\20\7\5\2\2\20\21\5\2"+
		"\2\2\21\27\3\2\2\2\22\23\5\4\3\2\23\24\7\6\2\2\24\25\5\2\2\2\25\27\3\2"+
		"\2\2\26\16\3\2\2\2\26\22\3\2\2\2\27\3\3\2\2\2\30\31\7\7\2\2\31\34\5\6"+
		"\4\2\32\34\5\b\5\2\33\30\3\2\2\2\33\32\3\2\2\2\34\5\3\2\2\2\35\36\7\4"+
		"\2\2\36\37\7\b\2\2\37$\5\4\3\2 !\5\2\2\2!\"\7\b\2\2\"$\3\2\2\2#\35\3\2"+
		"\2\2# \3\2\2\2$\7\3\2\2\2%&\5\f\7\2&\'\5\n\6\2\'\t\3\2\2\2()\7\t\2\2)"+
		"*\5\2\2\2*+\7\n\2\2+,\5\n\6\2,\61\3\2\2\2-.\7\13\2\2./\7\4\2\2/\61\5\n"+
		"\6\2\60(\3\2\2\2\60-\3\2\2\2\61\13\3\2\2\2\62\63\t\2\2\2\63\r\3\2\2\2"+
		"\6\26\33#\60";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}