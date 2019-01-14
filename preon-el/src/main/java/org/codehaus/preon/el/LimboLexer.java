// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/codehaus/preon/el/Limbo.g 2019-01-15 00:44:03

package org.codehaus.preon.el;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LimboLexer extends Lexer {
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

    public LimboLexer() {;} 
    public LimboLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LimboLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "org/codehaus/preon/el/Limbo.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:7:7: ( '<=' )
            // org/codehaus/preon/el/Limbo.g:7:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:8:7: ( '>=' )
            // org/codehaus/preon/el/Limbo.g:8:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:9:7: ( '<' )
            // org/codehaus/preon/el/Limbo.g:9:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:10:7: ( '>' )
            // org/codehaus/preon/el/Limbo.g:10:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:11:7: ( '==' )
            // org/codehaus/preon/el/Limbo.g:11:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:12:7: ( '&&' )
            // org/codehaus/preon/el/Limbo.g:12:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:13:7: ( '||' )
            // org/codehaus/preon/el/Limbo.g:13:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:14:7: ( '(' )
            // org/codehaus/preon/el/Limbo.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:15:7: ( ')' )
            // org/codehaus/preon/el/Limbo.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:16:7: ( '+' )
            // org/codehaus/preon/el/Limbo.g:16:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:17:7: ( '-' )
            // org/codehaus/preon/el/Limbo.g:17:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:18:7: ( '*' )
            // org/codehaus/preon/el/Limbo.g:18:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:19:7: ( '/' )
            // org/codehaus/preon/el/Limbo.g:19:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:20:7: ( '^' )
            // org/codehaus/preon/el/Limbo.g:20:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:21:7: ( '.' )
            // org/codehaus/preon/el/Limbo.g:21:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:22:7: ( '[' )
            // org/codehaus/preon/el/Limbo.g:22:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:23:7: ( ']' )
            // org/codehaus/preon/el/Limbo.g:23:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:72:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // org/codehaus/preon/el/Limbo.g:72:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // org/codehaus/preon/el/Limbo.g:72:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "BININT"
    public final void mBININT() throws RecognitionException {
        try {
            int _type = BININT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:73:8: ( '0' 'b' ( '0' | '1' )+ )
            // org/codehaus/preon/el/Limbo.g:73:10: '0' 'b' ( '0' | '1' )+
            {
            match('0'); 
            match('b'); 
            // org/codehaus/preon/el/Limbo.g:73:18: ( '0' | '1' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BININT"

    // $ANTLR start "HEXINT"
    public final void mHEXINT() throws RecognitionException {
        try {
            int _type = HEXINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:74:8: ( '0' 'x' ( '0' .. '7' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // org/codehaus/preon/el/Limbo.g:74:10: '0' 'x' ( '0' .. '7' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            match('x'); 
            // org/codehaus/preon/el/Limbo.g:74:18: ( '0' .. '7' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='7')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEXINT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:75:6: ( ( '0' .. '9' )+ )
            // org/codehaus/preon/el/Limbo.g:75:8: ( '0' .. '9' )+
            {
            // org/codehaus/preon/el/Limbo.g:75:8: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:75:8: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:76:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // org/codehaus/preon/el/Limbo.g:76:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // org/codehaus/preon/el/Limbo.g:76:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/codehaus/preon/el/Limbo.g:77:8: ( '\\'' (~ ( '\\'' ) )* '\\'' )
            // org/codehaus/preon/el/Limbo.g:77:10: '\\'' (~ ( '\\'' ) )* '\\''
            {
            match('\''); 
            // org/codehaus/preon/el/Limbo.g:77:15: (~ ( '\\'' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // org/codehaus/preon/el/Limbo.g:77:15: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\''); 

                // Strip left and right quotes
                String text = getText();
                text = text.substring(1, text.length()-1);
                setText(text);
                

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // org/codehaus/preon/el/Limbo.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | ID | BININT | HEXINT | INT | WS | STRING )
        int alt7=23;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // org/codehaus/preon/el/Limbo.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // org/codehaus/preon/el/Limbo.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // org/codehaus/preon/el/Limbo.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // org/codehaus/preon/el/Limbo.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // org/codehaus/preon/el/Limbo.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // org/codehaus/preon/el/Limbo.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // org/codehaus/preon/el/Limbo.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // org/codehaus/preon/el/Limbo.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // org/codehaus/preon/el/Limbo.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // org/codehaus/preon/el/Limbo.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // org/codehaus/preon/el/Limbo.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // org/codehaus/preon/el/Limbo.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // org/codehaus/preon/el/Limbo.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // org/codehaus/preon/el/Limbo.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // org/codehaus/preon/el/Limbo.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // org/codehaus/preon/el/Limbo.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // org/codehaus/preon/el/Limbo.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // org/codehaus/preon/el/Limbo.g:1:112: ID
                {
                mID(); 

                }
                break;
            case 19 :
                // org/codehaus/preon/el/Limbo.g:1:115: BININT
                {
                mBININT(); 

                }
                break;
            case 20 :
                // org/codehaus/preon/el/Limbo.g:1:122: HEXINT
                {
                mHEXINT(); 

                }
                break;
            case 21 :
                // org/codehaus/preon/el/Limbo.g:1:129: INT
                {
                mINT(); 

                }
                break;
            case 22 :
                // org/codehaus/preon/el/Limbo.g:1:133: WS
                {
                mWS(); 

                }
                break;
            case 23 :
                // org/codehaus/preon/el/Limbo.g:1:136: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\26\1\30\16\uffff\1\22\11\uffff";
    static final String DFA7_eofS =
        "\33\uffff";
    static final String DFA7_minS =
        "\1\11\2\75\16\uffff\1\142\11\uffff";
    static final String DFA7_maxS =
        "\1\174\2\75\16\uffff\1\170\11\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
        "\1\21\1\22\1\uffff\1\25\1\26\1\27\1\1\1\3\1\2\1\4\1\23\1\24";
    static final String DFA7_specialS =
        "\33\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\23\2\uffff\1\23\22\uffff\1\23\5\uffff\1\4\1\24\1\6\1\7\1"+
            "\12\1\10\1\uffff\1\11\1\15\1\13\1\21\11\22\2\uffff\1\1\1\3\1"+
            "\2\2\uffff\32\20\1\16\1\uffff\1\17\1\14\2\uffff\32\20\1\uffff"+
            "\1\5",
            "\1\25",
            "\1\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\31\25\uffff\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | ID | BININT | HEXINT | INT | WS | STRING );";
        }
    }
 

}