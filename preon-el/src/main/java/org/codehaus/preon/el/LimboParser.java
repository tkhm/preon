// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/codehaus/preon/el/Limbo.g 2019-01-15 00:44:03

package org.codehaus.preon.el;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class LimboParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "REFERENCE", "PROP", "INDEX", "ID", "INT", "BININT", "HEXINT", "STRING", "WS", "'<='", "'>='", "'<'", "'>'", "'=='", "'&&'", "'||'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", "'.'", "'['", "']'"
    };
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int REFERENCE=4;
    public static final int PROP=5;
    public static final int INDEX=6;
    public static final int ID=7;
    public static final int INT=8;
    public static final int BININT=9;
    public static final int HEXINT=10;
    public static final int STRING=11;
    public static final int WS=12;

    // delegates
    // delegators


        public LimboParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LimboParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return LimboParser.tokenNames; }
    public String getGrammarFileName() { return "org/codehaus/preon/el/Limbo.g"; }


    public static class relationalOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalOp"
    // org/codehaus/preon/el/Limbo.g:22:1: relationalOp : ( '<=' | '>=' | '<' | '>' | '==' ) ;
    public final LimboParser.relationalOp_return relationalOp() throws RecognitionException {
        LimboParser.relationalOp_return retval = new LimboParser.relationalOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set1=null;

        Object set1_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:23:2: ( ( '<=' | '>=' | '<' | '>' | '==' ) )
            // org/codehaus/preon/el/Limbo.g:23:4: ( '<=' | '>=' | '<' | '>' | '==' )
            {
            root_0 = (Object)adaptor.nil();

            set1=(Token)input.LT(1);
            if ( (input.LA(1)>=13 && input.LA(1)<=17) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set1));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalOp"

    public static class condExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condExpression"
    // org/codehaus/preon/el/Limbo.g:26:1: condExpression : relationalExpression ( ( '&&' | '||' ) relationalExpression )* ;
    public final LimboParser.condExpression_return condExpression() throws RecognitionException {
        LimboParser.condExpression_return retval = new LimboParser.condExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set3=null;
        LimboParser.relationalExpression_return relationalExpression2 = null;

        LimboParser.relationalExpression_return relationalExpression4 = null;


        Object set3_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:27:2: ( relationalExpression ( ( '&&' | '||' ) relationalExpression )* )
            // org/codehaus/preon/el/Limbo.g:27:6: relationalExpression ( ( '&&' | '||' ) relationalExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_condExpression99);
            relationalExpression2=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression2.getTree());
            // org/codehaus/preon/el/Limbo.g:27:27: ( ( '&&' | '||' ) relationalExpression )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 18:
                case 19:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:27:28: ( '&&' | '||' ) relationalExpression
            	    {
            	    set3=(Token)input.LT(1);
            	    set3=(Token)input.LT(1);
            	    if ( (input.LA(1)>=18 && input.LA(1)<=19) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set3), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_condExpression109);
            	    relationalExpression4=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "condExpression"

    public static class relationalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpression"
    // org/codehaus/preon/el/Limbo.g:30:1: relationalExpression : ( additiveExpression ( relationalOp additiveExpression )? | '(' condExpression ')' );
    public final LimboParser.relationalExpression_return relationalExpression() throws RecognitionException {
        LimboParser.relationalExpression_return retval = new LimboParser.relationalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal8=null;
        Token char_literal10=null;
        LimboParser.additiveExpression_return additiveExpression5 = null;

        LimboParser.relationalOp_return relationalOp6 = null;

        LimboParser.additiveExpression_return additiveExpression7 = null;

        LimboParser.condExpression_return condExpression9 = null;


        Object char_literal8_tree=null;
        Object char_literal10_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:31:2: ( additiveExpression ( relationalOp additiveExpression )? | '(' condExpression ')' )
            int alt3=2;
            switch ( input.LA(1) ) {
            case ID:
            case INT:
            case BININT:
            case HEXINT:
            case STRING:
                {
                alt3=1;
                }
                break;
            case 20:
                {
                int LA3_3 = input.LA(2);

                if ( (synpred8_Limbo()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // org/codehaus/preon/el/Limbo.g:31:4: additiveExpression ( relationalOp additiveExpression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_additiveExpression_in_relationalExpression129);
                    additiveExpression5=additiveExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression5.getTree());
                    // org/codehaus/preon/el/Limbo.g:31:23: ( relationalOp additiveExpression )?
                    int alt2=2;
                    switch ( input.LA(1) ) {
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            {
                            alt2=1;
                            }
                            break;
                    }

                    switch (alt2) {
                        case 1 :
                            // org/codehaus/preon/el/Limbo.g:31:24: relationalOp additiveExpression
                            {
                            pushFollow(FOLLOW_relationalOp_in_relationalExpression132);
                            relationalOp6=relationalOp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(relationalOp6.getTree(), root_0);
                            pushFollow(FOLLOW_additiveExpression_in_relationalExpression135);
                            additiveExpression7=additiveExpression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression7.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // org/codehaus/preon/el/Limbo.g:32:6: '(' condExpression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal8=(Token)match(input,20,FOLLOW_20_in_relationalExpression144); if (state.failed) return retval;
                    pushFollow(FOLLOW_condExpression_in_relationalExpression147);
                    condExpression9=condExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, condExpression9.getTree());
                    char_literal10=(Token)match(input,21,FOLLOW_21_in_relationalExpression149); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalExpression"

    public static class additiveExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpression"
    // org/codehaus/preon/el/Limbo.g:35:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final LimboParser.additiveExpression_return additiveExpression() throws RecognitionException {
        LimboParser.additiveExpression_return retval = new LimboParser.additiveExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set12=null;
        LimboParser.multiplicativeExpression_return multiplicativeExpression11 = null;

        LimboParser.multiplicativeExpression_return multiplicativeExpression13 = null;


        Object set12_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:36:2: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // org/codehaus/preon/el/Limbo.g:36:5: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression162);
            multiplicativeExpression11=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression11.getTree());
            // org/codehaus/preon/el/Limbo.g:36:29: ( ( '+' | '-' ) multiplicativeExpression )*
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case 22:
                case 23:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:36:30: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    set12=(Token)input.LT(1);
            	    set12=(Token)input.LT(1);
            	    if ( (input.LA(1)>=22 && input.LA(1)<=23) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set12), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression171);
            	    multiplicativeExpression13=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression13.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "additiveExpression"

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExpression"
    // org/codehaus/preon/el/Limbo.g:39:1: multiplicativeExpression : powExpression ( ( '*' | '/' ) powExpression )* ;
    public final LimboParser.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        LimboParser.multiplicativeExpression_return retval = new LimboParser.multiplicativeExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set15=null;
        LimboParser.powExpression_return powExpression14 = null;

        LimboParser.powExpression_return powExpression16 = null;


        Object set15_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:40:2: ( powExpression ( ( '*' | '/' ) powExpression )* )
            // org/codehaus/preon/el/Limbo.g:40:5: powExpression ( ( '*' | '/' ) powExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_powExpression_in_multiplicativeExpression185);
            powExpression14=powExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpression14.getTree());
            // org/codehaus/preon/el/Limbo.g:40:19: ( ( '*' | '/' ) powExpression )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case 24:
                case 25:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:40:20: ( '*' | '/' ) powExpression
            	    {
            	    set15=(Token)input.LT(1);
            	    set15=(Token)input.LT(1);
            	    if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set15), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_powExpression_in_multiplicativeExpression195);
            	    powExpression16=powExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpression16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"

    public static class powExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "powExpression"
    // org/codehaus/preon/el/Limbo.g:43:1: powExpression : unaryExpression ( '^' powExpression )? ;
    public final LimboParser.powExpression_return powExpression() throws RecognitionException {
        LimboParser.powExpression_return retval = new LimboParser.powExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal18=null;
        LimboParser.unaryExpression_return unaryExpression17 = null;

        LimboParser.powExpression_return powExpression19 = null;


        Object char_literal18_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:44:2: ( unaryExpression ( '^' powExpression )? )
            // org/codehaus/preon/el/Limbo.g:44:4: unaryExpression ( '^' powExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_powExpression208);
            unaryExpression17=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression17.getTree());
            // org/codehaus/preon/el/Limbo.g:44:20: ( '^' powExpression )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case 26:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // org/codehaus/preon/el/Limbo.g:44:21: '^' powExpression
                    {
                    char_literal18=(Token)match(input,26,FOLLOW_26_in_powExpression211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal18_tree = (Object)adaptor.create(char_literal18);
                    root_0 = (Object)adaptor.becomeRoot(char_literal18_tree, root_0);
                    }
                    pushFollow(FOLLOW_powExpression_in_powExpression214);
                    powExpression19=powExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpression19.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "powExpression"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpression"
    // org/codehaus/preon/el/Limbo.g:47:1: unaryExpression : ( number | reference | '(' additiveExpression ')' | string );
    public final LimboParser.unaryExpression_return unaryExpression() throws RecognitionException {
        LimboParser.unaryExpression_return retval = new LimboParser.unaryExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal22=null;
        Token char_literal24=null;
        LimboParser.number_return number20 = null;

        LimboParser.reference_return reference21 = null;

        LimboParser.additiveExpression_return additiveExpression23 = null;

        LimboParser.string_return string25 = null;


        Object char_literal22_tree=null;
        Object char_literal24_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:48:3: ( number | reference | '(' additiveExpression ')' | string )
            int alt7=4;
            switch ( input.LA(1) ) {
            case INT:
            case BININT:
            case HEXINT:
                {
                alt7=1;
                }
                break;
            case ID:
                {
                alt7=2;
                }
                break;
            case 20:
                {
                alt7=3;
                }
                break;
            case STRING:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // org/codehaus/preon/el/Limbo.g:48:6: number
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_in_unaryExpression229);
                    number20=number();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number20.getTree());

                    }
                    break;
                case 2 :
                    // org/codehaus/preon/el/Limbo.g:49:5: reference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_reference_in_unaryExpression235);
                    reference21=reference();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, reference21.getTree());

                    }
                    break;
                case 3 :
                    // org/codehaus/preon/el/Limbo.g:50:5: '(' additiveExpression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal22=(Token)match(input,20,FOLLOW_20_in_unaryExpression241); if (state.failed) return retval;
                    pushFollow(FOLLOW_additiveExpression_in_unaryExpression244);
                    additiveExpression23=additiveExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression23.getTree());
                    char_literal24=(Token)match(input,21,FOLLOW_21_in_unaryExpression246); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // org/codehaus/preon/el/Limbo.g:51:6: string
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_string_in_unaryExpression254);
                    string25=string();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string25.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class reference_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "reference"
    // org/codehaus/preon/el/Limbo.g:54:1: reference : ID ( selector )* -> ^( REFERENCE ID ( selector )* ) ;
    public final LimboParser.reference_return reference() throws RecognitionException {
        LimboParser.reference_return retval = new LimboParser.reference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID26=null;
        LimboParser.selector_return selector27 = null;


        Object ID26_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_selector=new RewriteRuleSubtreeStream(adaptor,"rule selector");
        try {
            // org/codehaus/preon/el/Limbo.g:55:2: ( ID ( selector )* -> ^( REFERENCE ID ( selector )* ) )
            // org/codehaus/preon/el/Limbo.g:55:4: ID ( selector )*
            {
            ID26=(Token)match(input,ID,FOLLOW_ID_in_reference266); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID26);

            // org/codehaus/preon/el/Limbo.g:55:7: ( selector )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case 27:
                case 28:
                    {
                    alt8=1;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:0:0: selector
            	    {
            	    pushFollow(FOLLOW_selector_in_reference268);
            	    selector27=selector();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selector.add(selector27.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);



            // AST REWRITE
            // elements: ID, selector
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 55:17: -> ^( REFERENCE ID ( selector )* )
            {
                // org/codehaus/preon/el/Limbo.g:55:20: ^( REFERENCE ID ( selector )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REFERENCE, "REFERENCE"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // org/codehaus/preon/el/Limbo.g:55:35: ( selector )*
                while ( stream_selector.hasNext() ) {
                    adaptor.addChild(root_1, stream_selector.nextTree());

                }
                stream_selector.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "reference"

    public static class selector_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selector"
    // org/codehaus/preon/el/Limbo.g:58:1: selector : ( '.' ID -> ^( PROP ID ) | '[' additiveExpression ']' -> ^( INDEX additiveExpression ) );
    public final LimboParser.selector_return selector() throws RecognitionException {
        LimboParser.selector_return retval = new LimboParser.selector_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal28=null;
        Token ID29=null;
        Token char_literal30=null;
        Token char_literal32=null;
        LimboParser.additiveExpression_return additiveExpression31 = null;


        Object char_literal28_tree=null;
        Object ID29_tree=null;
        Object char_literal30_tree=null;
        Object char_literal32_tree=null;
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
        RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_additiveExpression=new RewriteRuleSubtreeStream(adaptor,"rule additiveExpression");
        try {
            // org/codehaus/preon/el/Limbo.g:59:5: ( '.' ID -> ^( PROP ID ) | '[' additiveExpression ']' -> ^( INDEX additiveExpression ) )
            int alt9=2;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // org/codehaus/preon/el/Limbo.g:59:9: '.' ID
                    {
                    char_literal28=(Token)match(input,27,FOLLOW_27_in_selector296); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_27.add(char_literal28);

                    ID29=(Token)match(input,ID,FOLLOW_ID_in_selector298); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID29);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 59:16: -> ^( PROP ID )
                    {
                        // org/codehaus/preon/el/Limbo.g:59:19: ^( PROP ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROP, "PROP"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // org/codehaus/preon/el/Limbo.g:60:9: '[' additiveExpression ']'
                    {
                    char_literal30=(Token)match(input,28,FOLLOW_28_in_selector316); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_28.add(char_literal30);

                    pushFollow(FOLLOW_additiveExpression_in_selector318);
                    additiveExpression31=additiveExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_additiveExpression.add(additiveExpression31.getTree());
                    char_literal32=(Token)match(input,29,FOLLOW_29_in_selector320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_29.add(char_literal32);



                    // AST REWRITE
                    // elements: additiveExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 60:36: -> ^( INDEX additiveExpression )
                    {
                        // org/codehaus/preon/el/Limbo.g:60:39: ^( INDEX additiveExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INDEX, "INDEX"), root_1);

                        adaptor.addChild(root_1, stream_additiveExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selector"

    public static class number_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number"
    // org/codehaus/preon/el/Limbo.g:64:1: number : ( INT | BININT | HEXINT );
    public final LimboParser.number_return number() throws RecognitionException {
        LimboParser.number_return retval = new LimboParser.number_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set33=null;

        Object set33_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:65:5: ( INT | BININT | HEXINT )
            // org/codehaus/preon/el/Limbo.g:
            {
            root_0 = (Object)adaptor.nil();

            set33=(Token)input.LT(1);
            if ( (input.LA(1)>=INT && input.LA(1)<=HEXINT) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set33));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number"

    public static class string_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string"
    // org/codehaus/preon/el/Limbo.g:69:1: string : STRING ;
    public final LimboParser.string_return string() throws RecognitionException {
        LimboParser.string_return retval = new LimboParser.string_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING34=null;

        Object STRING34_tree=null;

        try {
            // org/codehaus/preon/el/Limbo.g:70:5: ( STRING )
            // org/codehaus/preon/el/Limbo.g:70:9: STRING
            {
            root_0 = (Object)adaptor.nil();

            STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_string385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING34_tree = (Object)adaptor.create(STRING34);
            adaptor.addChild(root_0, STRING34_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "string"

    // $ANTLR start synpred8_Limbo
    public final void synpred8_Limbo_fragment() throws RecognitionException {   
        // org/codehaus/preon/el/Limbo.g:31:4: ( additiveExpression ( relationalOp additiveExpression )? )
        // org/codehaus/preon/el/Limbo.g:31:4: additiveExpression ( relationalOp additiveExpression )?
        {
        pushFollow(FOLLOW_additiveExpression_in_synpred8_Limbo129);
        additiveExpression();

        state._fsp--;
        if (state.failed) return ;
        // org/codehaus/preon/el/Limbo.g:31:23: ( relationalOp additiveExpression )?
        int alt10=2;
        switch ( input.LA(1) ) {
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                {
                alt10=1;
                }
                break;
        }

        switch (alt10) {
            case 1 :
                // org/codehaus/preon/el/Limbo.g:31:24: relationalOp additiveExpression
                {
                pushFollow(FOLLOW_relationalOp_in_synpred8_Limbo132);
                relationalOp();

                state._fsp--;
                if (state.failed) return ;
                pushFollow(FOLLOW_additiveExpression_in_synpred8_Limbo135);
                additiveExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred8_Limbo

    // Delegated rules

    public final boolean synpred8_Limbo() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Limbo_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_set_in_relationalOp67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_condExpression99 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_condExpression102 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_relationalExpression_in_condExpression109 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression129 = new BitSet(new long[]{0x000000000003E002L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression132 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_relationalExpression144 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_condExpression_in_relationalExpression147 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_relationalExpression149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression162 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_set_in_additiveExpression164 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression171 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_powExpression_in_multiplicativeExpression185 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression188 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_powExpression_in_multiplicativeExpression195 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_unaryExpression_in_powExpression208 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_powExpression211 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_powExpression_in_powExpression214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_unaryExpression229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reference_in_unaryExpression235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unaryExpression241 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_additiveExpression_in_unaryExpression244 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_unaryExpression246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_unaryExpression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_reference266 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_selector_in_reference268 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_selector296 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ID_in_selector298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_selector316 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_additiveExpression_in_selector318 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_selector320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_number0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred8_Limbo129 = new BitSet(new long[]{0x000000000003E002L});
    public static final BitSet FOLLOW_relationalOp_in_synpred8_Limbo132 = new BitSet(new long[]{0x0000000000100F80L});
    public static final BitSet FOLLOW_additiveExpression_in_synpred8_Limbo135 = new BitSet(new long[]{0x0000000000000002L});

}