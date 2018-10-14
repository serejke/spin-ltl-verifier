// Generated from ru/ifmo/ctddev/verifier/Ltl.g4 by ANTLR 4.7.1
package ru.ifmo.ctddev.verifier;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LtlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, NUM_INT=3, EQUAL=4, NOT_EQUAL=5, LT=6, LE=7, GE=8, GT=9, 
		SEMI=10, COMMA=11, PLUS=12, MINUS=13, STAR=14, SLASH=15, LPAREN=16, RPAREN=17, 
		OR=18, AND=19, IMPLICATION=20, NOT=21, G=22, F=23, U=24, X=25, R=26, WS=27, 
		IDENT=28;
	public static final int
		RULE_ltl = 0, RULE_formula = 1, RULE_condition = 2, RULE_expr = 3, RULE_simpleExpr = 4, 
		RULE_term = 5, RULE_signedFactor = 6, RULE_factor = 7, RULE_trueOrFalse = 8, 
		RULE_var = 9;
	public static final String[] ruleNames = {
		"ltl", "formula", "condition", "expr", "simpleExpr", "term", "signedFactor", 
		"factor", "trueOrFalse", "var"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", null, "'='", "'!='", "'<'", "'<='", "'>='", 
		"'>'", "';'", "','", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'|'", 
		"'&'", "'->'", "'!'", "'G'", "'F'", "'U'", "'X'", "'R'", "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "NUM_INT", "EQUAL", "NOT_EQUAL", "LT", "LE", "GE", 
		"GT", "SEMI", "COMMA", "PLUS", "MINUS", "STAR", "SLASH", "LPAREN", "RPAREN", 
		"OR", "AND", "IMPLICATION", "NOT", "G", "F", "U", "X", "R", "WS", "IDENT"
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
	public String getGrammarFileName() { return "Ltl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LtlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LtlContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LtlParser.EOF, 0); }
		public LtlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtlContext ltl() throws RecognitionException {
		LtlContext _localctx = new LtlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ltl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			formula(0);
			setState(21);
			match(EOF);
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

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LtlAndContext extends FormulaContext {
		public FormulaContext left;
		public FormulaContext right;
		public TerminalNode AND() { return getToken(LtlParser.AND, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LtlAndContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlImplContext extends FormulaContext {
		public FormulaContext left;
		public FormulaContext right;
		public TerminalNode IMPLICATION() { return getToken(LtlParser.IMPLICATION, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LtlImplContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlImpl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlImpl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlImpl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlParenContext extends FormulaContext {
		public FormulaContext body;
		public TerminalNode LPAREN() { return getToken(LtlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LtlParser.RPAREN, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public LtlParenContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlUntilContext extends FormulaContext {
		public FormulaContext left;
		public FormulaContext right;
		public TerminalNode U() { return getToken(LtlParser.U, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LtlUntilContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlUntil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlUntil(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlFutureContext extends FormulaContext {
		public FormulaContext body;
		public TerminalNode F() { return getToken(LtlParser.F, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public LtlFutureContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlFuture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlFuture(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlFuture(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlReleaseContext extends FormulaContext {
		public FormulaContext left;
		public FormulaContext right;
		public TerminalNode R() { return getToken(LtlParser.R, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LtlReleaseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlRelease(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlRelease(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlRelease(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlGloballyContext extends FormulaContext {
		public FormulaContext body;
		public TerminalNode G() { return getToken(LtlParser.G, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public LtlGloballyContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlGlobally(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlGlobally(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlGlobally(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlNegContext extends FormulaContext {
		public TerminalNode NOT() { return getToken(LtlParser.NOT, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public LtlNegContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlNextContext extends FormulaContext {
		public FormulaContext body;
		public TerminalNode X() { return getToken(LtlParser.X, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public LtlNextContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlNext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlNext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlExprContext extends FormulaContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LtlExprContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtlOrContext extends FormulaContext {
		public FormulaContext left;
		public FormulaContext right;
		public TerminalNode OR() { return getToken(LtlParser.OR, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LtlOrContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterLtlOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitLtlOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitLtlOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new LtlParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(24);
				match(LPAREN);
				setState(25);
				((LtlParenContext)_localctx).body = formula(0);
				setState(26);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new LtlExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				expr();
				}
				break;
			case 3:
				{
				_localctx = new LtlNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(NOT);
				setState(30);
				formula(9);
				}
				break;
			case 4:
				{
				_localctx = new LtlNextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(X);
				setState(32);
				((LtlNextContext)_localctx).body = formula(8);
				}
				break;
			case 5:
				{
				_localctx = new LtlFutureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(F);
				setState(34);
				((LtlFutureContext)_localctx).body = formula(7);
				}
				break;
			case 6:
				{
				_localctx = new LtlGloballyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(G);
				setState(36);
				((LtlGloballyContext)_localctx).body = formula(6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(54);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new LtlUntilContext(new FormulaContext(_parentctx, _parentState));
						((LtlUntilContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(39);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(40);
						match(U);
						setState(41);
						((LtlUntilContext)_localctx).right = formula(6);
						}
						break;
					case 2:
						{
						_localctx = new LtlReleaseContext(new FormulaContext(_parentctx, _parentState));
						((LtlReleaseContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(42);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(43);
						match(R);
						setState(44);
						((LtlReleaseContext)_localctx).right = formula(5);
						}
						break;
					case 3:
						{
						_localctx = new LtlAndContext(new FormulaContext(_parentctx, _parentState));
						((LtlAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(45);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(46);
						match(AND);
						setState(47);
						((LtlAndContext)_localctx).right = formula(4);
						}
						break;
					case 4:
						{
						_localctx = new LtlOrContext(new FormulaContext(_parentctx, _parentState));
						((LtlOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(48);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(49);
						match(OR);
						setState(50);
						((LtlOrContext)_localctx).right = formula(3);
						}
						break;
					case 5:
						{
						_localctx = new LtlImplContext(new FormulaContext(_parentctx, _parentState));
						((LtlImplContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(51);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(52);
						match(IMPLICATION);
						setState(53);
						((LtlImplContext)_localctx).right = formula(2);
						}
						break;
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondImplContext extends ConditionContext {
		public ConditionContext left;
		public ConditionContext right;
		public TerminalNode IMPLICATION() { return getToken(LtlParser.IMPLICATION, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public CondImplContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterCondImpl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitCondImpl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitCondImpl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondParenContext extends ConditionContext {
		public ConditionContext body;
		public TerminalNode LPAREN() { return getToken(LtlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LtlParser.RPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public CondParenContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterCondParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitCondParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitCondParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondExprContext extends ConditionContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterCondExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitCondExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondAndContext extends ConditionContext {
		public ConditionContext left;
		public ConditionContext right;
		public TerminalNode AND() { return getToken(LtlParser.AND, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public CondAndContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterCondAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitCondAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitCondAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondOrContext extends ConditionContext {
		public ConditionContext left;
		public ConditionContext right;
		public TerminalNode OR() { return getToken(LtlParser.OR, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public CondOrContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterCondOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitCondOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitCondOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondNotContext extends ConditionContext {
		public ConditionContext body;
		public TerminalNode NOT() { return getToken(LtlParser.NOT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public CondNotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterCondNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitCondNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitCondNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new CondParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(60);
				match(LPAREN);
				setState(61);
				((CondParenContext)_localctx).body = condition(0);
				setState(62);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new CondExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				expr();
				}
				break;
			case 3:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(NOT);
				setState(66);
				((CondNotContext)_localctx).body = condition(4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(78);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new ConditionContext(_parentctx, _parentState));
						((CondAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(69);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(70);
						match(AND);
						setState(71);
						((CondAndContext)_localctx).right = condition(4);
						}
						break;
					case 2:
						{
						_localctx = new CondOrContext(new ConditionContext(_parentctx, _parentState));
						((CondOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(72);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(73);
						match(OR);
						setState(74);
						((CondOrContext)_localctx).right = condition(3);
						}
						break;
					case 3:
						{
						_localctx = new CondImplContext(new ConditionContext(_parentctx, _parentState));
						((CondImplContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(75);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(76);
						match(IMPLICATION);
						setState(77);
						((CondImplContext)_localctx).right = condition(2);
						}
						break;
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public SimpleExprContext left;
		public Token cmpSign;
		public SimpleExprContext right;
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(LtlParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(LtlParser.NOT_EQUAL, 0); }
		public TerminalNode LT() { return getToken(LtlParser.LT, 0); }
		public TerminalNode LE() { return getToken(LtlParser.LE, 0); }
		public TerminalNode GE() { return getToken(LtlParser.GE, 0); }
		public TerminalNode GT() { return getToken(LtlParser.GT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((ExprContext)_localctx).left = simpleExpr();
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(84);
				((ExprContext)_localctx).cmpSign = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << LT) | (1L << LE) | (1L << GE) | (1L << GT))) != 0)) ) {
					((ExprContext)_localctx).cmpSign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(85);
				((ExprContext)_localctx).right = simpleExpr();
				}
				break;
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

	public static class SimpleExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LtlParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LtlParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LtlParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LtlParser.MINUS, i);
		}
		public SimpleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterSimpleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitSimpleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitSimpleExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExprContext simpleExpr() throws RecognitionException {
		SimpleExprContext _localctx = new SimpleExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			term();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(90);
					term();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SignedTermContext extends TermContext {
		public List<SignedFactorContext> signedFactor() {
			return getRuleContexts(SignedFactorContext.class);
		}
		public SignedFactorContext signedFactor(int i) {
			return getRuleContext(SignedFactorContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(LtlParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(LtlParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(LtlParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(LtlParser.SLASH, i);
		}
		public SignedTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterSignedTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitSignedTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitSignedTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenTermContext extends TermContext {
		public TerminalNode LPAREN() { return getToken(LtlParser.LPAREN, 0); }
		public SimpleExprContext simpleExpr() {
			return getRuleContext(SimpleExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LtlParser.RPAREN, 0); }
		public ParenTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterParenTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitParenTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitParenTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		int _la;
		try {
			int _alt;
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NUM_INT:
			case MINUS:
			case IDENT:
				_localctx = new SignedTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				signedFactor();
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(97);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(98);
						signedFactor();
						}
						} 
					}
					setState(103);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				break;
			case LPAREN:
				_localctx = new ParenTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(LPAREN);
				setState(105);
				simpleExpr();
				setState(106);
				match(RPAREN);
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

	public static class SignedFactorContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(LtlParser.MINUS, 0); }
		public SignedFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterSignedFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitSignedFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitSignedFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedFactorContext signedFactor() throws RecognitionException {
		SignedFactorContext _localctx = new SignedFactorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_signedFactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(110);
				match(MINUS);
				}
			}

			setState(113);
			factor();
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

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactVarContext extends FactorContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FactVarContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterFactVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitFactVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitFactVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactNumberContext extends FactorContext {
		public TerminalNode NUM_INT() { return getToken(LtlParser.NUM_INT, 0); }
		public FactNumberContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterFactNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitFactNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitFactNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactTrueOrFalseContext extends FactorContext {
		public TrueOrFalseContext trueOrFalse() {
			return getRuleContext(TrueOrFalseContext.class,0);
		}
		public FactTrueOrFalseContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterFactTrueOrFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitFactTrueOrFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitFactTrueOrFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_INT:
				_localctx = new FactNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(NUM_INT);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new FactTrueOrFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				trueOrFalse();
				}
				break;
			case IDENT:
				_localctx = new FactVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				var();
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

	public static class TrueOrFalseContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(LtlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LtlParser.FALSE, 0); }
		public TrueOrFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueOrFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterTrueOrFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitTrueOrFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitTrueOrFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueOrFalseContext trueOrFalse() throws RecognitionException {
		TrueOrFalseContext _localctx = new TrueOrFalseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_trueOrFalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LtlParser.IDENT, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LtlListener ) ((LtlListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LtlVisitor ) return ((LtlVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(IDENT);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 2:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3(\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\39\n\3\f\3\16\3<\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4F\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4Q\n\4\f\4\16\4T\13\4\3\5\3\5\3\5"+
		"\5\5Y\n\5\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\7\3\7\3\7\7\7f\n\7\f\7"+
		"\16\7i\13\7\3\7\3\7\3\7\3\7\5\7o\n\7\3\b\5\br\n\b\3\b\3\b\3\t\3\t\3\t"+
		"\5\ty\n\t\3\n\3\n\3\13\3\13\3\13\2\4\4\6\f\2\4\6\b\n\f\16\20\22\24\2\6"+
		"\3\2\6\13\3\2\16\17\3\2\20\21\3\2\3\4\2\u008a\2\26\3\2\2\2\4\'\3\2\2\2"+
		"\6E\3\2\2\2\bU\3\2\2\2\nZ\3\2\2\2\fn\3\2\2\2\16q\3\2\2\2\20x\3\2\2\2\22"+
		"z\3\2\2\2\24|\3\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31\32\b"+
		"\3\1\2\32\33\7\22\2\2\33\34\5\4\3\2\34\35\7\23\2\2\35(\3\2\2\2\36(\5\b"+
		"\5\2\37 \7\27\2\2 (\5\4\3\13!\"\7\33\2\2\"(\5\4\3\n#$\7\31\2\2$(\5\4\3"+
		"\t%&\7\30\2\2&(\5\4\3\b\'\31\3\2\2\2\'\36\3\2\2\2\'\37\3\2\2\2\'!\3\2"+
		"\2\2\'#\3\2\2\2\'%\3\2\2\2(:\3\2\2\2)*\f\7\2\2*+\7\32\2\2+9\5\4\3\b,-"+
		"\f\6\2\2-.\7\34\2\2.9\5\4\3\7/\60\f\5\2\2\60\61\7\25\2\2\619\5\4\3\6\62"+
		"\63\f\4\2\2\63\64\7\24\2\2\649\5\4\3\5\65\66\f\3\2\2\66\67\7\26\2\2\67"+
		"9\5\4\3\48)\3\2\2\28,\3\2\2\28/\3\2\2\28\62\3\2\2\28\65\3\2\2\29<\3\2"+
		"\2\2:8\3\2\2\2:;\3\2\2\2;\5\3\2\2\2<:\3\2\2\2=>\b\4\1\2>?\7\22\2\2?@\5"+
		"\6\4\2@A\7\23\2\2AF\3\2\2\2BF\5\b\5\2CD\7\27\2\2DF\5\6\4\6E=\3\2\2\2E"+
		"B\3\2\2\2EC\3\2\2\2FR\3\2\2\2GH\f\5\2\2HI\7\25\2\2IQ\5\6\4\6JK\f\4\2\2"+
		"KL\7\24\2\2LQ\5\6\4\5MN\f\3\2\2NO\7\26\2\2OQ\5\6\4\4PG\3\2\2\2PJ\3\2\2"+
		"\2PM\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2\2TR\3\2\2\2UX\5\n"+
		"\6\2VW\t\2\2\2WY\5\n\6\2XV\3\2\2\2XY\3\2\2\2Y\t\3\2\2\2Z_\5\f\7\2[\\\t"+
		"\3\2\2\\^\5\f\7\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\13\3\2\2\2"+
		"a_\3\2\2\2bg\5\16\b\2cd\t\4\2\2df\5\16\b\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2"+
		"\2gh\3\2\2\2ho\3\2\2\2ig\3\2\2\2jk\7\22\2\2kl\5\n\6\2lm\7\23\2\2mo\3\2"+
		"\2\2nb\3\2\2\2nj\3\2\2\2o\r\3\2\2\2pr\7\17\2\2qp\3\2\2\2qr\3\2\2\2rs\3"+
		"\2\2\2st\5\20\t\2t\17\3\2\2\2uy\7\5\2\2vy\5\22\n\2wy\5\24\13\2xu\3\2\2"+
		"\2xv\3\2\2\2xw\3\2\2\2y\21\3\2\2\2z{\t\5\2\2{\23\3\2\2\2|}\7\36\2\2}\25"+
		"\3\2\2\2\16\'8:EPRX_gnqx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}