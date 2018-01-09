// $ANTLR 3.0.1 ulNoActions.g 2018-01-09 14:55:06

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ulNoActionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IF", "WHILE", "PRINT", "PRINTLN", "RETURN", "ELSE", "OP", "ICONSTANT", "SCONSTANT", "FCONSTANT", "CCONSTANT", "TRUE", "FALSE", "ID", "TYPE", "WS", "COMMENT", "'('", "')'", "','", "'{'", "'}'", "';'", "'='", "'['", "']'"
    };
    public static final int PRINT=6;
    public static final int PRINTLN=7;
    public static final int SCONSTANT=12;
    public static final int COMMENT=20;
    public static final int RETURN=8;
    public static final int CCONSTANT=14;
    public static final int ELSE=9;
    public static final int ID=17;
    public static final int WS=19;
    public static final int EOF=-1;
    public static final int IF=4;
    public static final int TYPE=18;
    public static final int OP=10;
    public static final int TRUE=15;
    public static final int FCONSTANT=13;
    public static final int WHILE=5;
    public static final int FALSE=16;
    public static final int ICONSTANT=11;

        public ulNoActionsParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[27+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "ulNoActions.g"; }


    protected void mismatch (IntStream input, int ttype, BitSet follow)
            throws RecognitionException
    {
            throw new MismatchedTokenException(ttype, input);
    }
    public void recoverFromMismatchedSet (IntStream input,
                                          RecognitionException e,
                                          BitSet follow)
            throws RecognitionException
    {
            reportError(e);
            throw e;
    }



    // $ANTLR start program
    // ulNoActions.g:37:1: program : ( function )+ ;
    public final void program() throws RecognitionException {
        try {
            // ulNoActions.g:37:8: ( ( function )+ )
            // ulNoActions.g:37:10: ( function )+
            {
            // ulNoActions.g:37:10: ( function )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TYPE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ulNoActions.g:37:10: function
            	    {
            	    pushFollow(FOLLOW_function_in_program25);
            	    function();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end program


    // $ANTLR start function
    // ulNoActions.g:40:1: function : functionDecl functionBody ;
    public final void function() throws RecognitionException {
        try {
            // ulNoActions.g:40:9: ( functionDecl functionBody )
            // ulNoActions.g:40:11: functionDecl functionBody
            {
            pushFollow(FOLLOW_functionDecl_in_function35);
            functionDecl();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_functionBody_in_function37);
            functionBody();
            _fsp--;
            if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end function


    // $ANTLR start functionDecl
    // ulNoActions.g:43:1: functionDecl : compoundType identifier '(' formalParameters ')' ;
    public final void functionDecl() throws RecognitionException {
        try {
            // ulNoActions.g:43:13: ( compoundType identifier '(' formalParameters ')' )
            // ulNoActions.g:43:15: compoundType identifier '(' formalParameters ')'
            {
            pushFollow(FOLLOW_compoundType_in_functionDecl46);
            compoundType();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_identifier_in_functionDecl48);
            identifier();
            _fsp--;
            if (failed) return ;
            match(input,21,FOLLOW_21_in_functionDecl50); if (failed) return ;
            pushFollow(FOLLOW_formalParameters_in_functionDecl52);
            formalParameters();
            _fsp--;
            if (failed) return ;
            match(input,22,FOLLOW_22_in_functionDecl54); if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end functionDecl


    // $ANTLR start formalParameters
    // ulNoActions.g:46:1: formalParameters : ( ( compoundType identifier ( moreFormals )* ) | );
    public final void formalParameters() throws RecognitionException {
        try {
            // ulNoActions.g:46:17: ( ( compoundType identifier ( moreFormals )* ) | )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==TYPE) ) {
                alt3=1;
            }
            else if ( (LA3_0==22) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("46:1: formalParameters : ( ( compoundType identifier ( moreFormals )* ) | );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ulNoActions.g:46:19: ( compoundType identifier ( moreFormals )* )
                    {
                    // ulNoActions.g:46:19: ( compoundType identifier ( moreFormals )* )
                    // ulNoActions.g:46:20: compoundType identifier ( moreFormals )*
                    {
                    pushFollow(FOLLOW_compoundType_in_formalParameters64);
                    compoundType();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_identifier_in_formalParameters66);
                    identifier();
                    _fsp--;
                    if (failed) return ;
                    // ulNoActions.g:46:44: ( moreFormals )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==23) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ulNoActions.g:46:44: moreFormals
                    	    {
                    	    pushFollow(FOLLOW_moreFormals_in_formalParameters68);
                    	    moreFormals();
                    	    _fsp--;
                    	    if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ulNoActions.g:48:5: 
                    {
                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end formalParameters


    // $ANTLR start moreFormals
    // ulNoActions.g:50:1: moreFormals : ',' compoundType identifier ;
    public final void moreFormals() throws RecognitionException {
        try {
            // ulNoActions.g:50:12: ( ',' compoundType identifier )
            // ulNoActions.g:50:14: ',' compoundType identifier
            {
            match(input,23,FOLLOW_23_in_moreFormals88); if (failed) return ;
            pushFollow(FOLLOW_compoundType_in_moreFormals90);
            compoundType();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_identifier_in_moreFormals92);
            identifier();
            _fsp--;
            if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end moreFormals


    // $ANTLR start functionBody
    // ulNoActions.g:53:1: functionBody : '{' ( varDecl )* ( statement )* '}' ;
    public final void functionBody() throws RecognitionException {
        try {
            // ulNoActions.g:53:13: ( '{' ( varDecl )* ( statement )* '}' )
            // ulNoActions.g:53:15: '{' ( varDecl )* ( statement )* '}'
            {
            match(input,24,FOLLOW_24_in_functionBody104); if (failed) return ;
            // ulNoActions.g:53:19: ( varDecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==TYPE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ulNoActions.g:53:19: varDecl
            	    {
            	    pushFollow(FOLLOW_varDecl_in_functionBody106);
            	    varDecl();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ulNoActions.g:53:28: ( statement )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=IF && LA5_0<=RETURN)||(LA5_0>=ICONSTANT && LA5_0<=ID)||LA5_0==21||LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ulNoActions.g:53:28: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_functionBody109);
            	    statement();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,25,FOLLOW_25_in_functionBody112); if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end functionBody


    // $ANTLR start varDecl
    // ulNoActions.g:56:1: varDecl : compoundType identifier ';' ;
    public final void varDecl() throws RecognitionException {
        try {
            // ulNoActions.g:56:8: ( compoundType identifier ';' )
            // ulNoActions.g:56:10: compoundType identifier ';'
            {
            pushFollow(FOLLOW_compoundType_in_varDecl121);
            compoundType();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_identifier_in_varDecl123);
            identifier();
            _fsp--;
            if (failed) return ;
            match(input,26,FOLLOW_26_in_varDecl125); if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end varDecl


    // $ANTLR start statement
    // ulNoActions.g:59:1: statement options {backtrack=true; } : ( ';' | identifier '=' expr ';' | identifier '[' expr ']' '=' expr ';' | expr ';' | IF '(' expr ')' block elseBlock | WHILE '(' expr ')' block | PRINT expr ';' | PRINTLN expr ';' | RETURN ( expr )? ';' );
    public final void statement() throws RecognitionException {
        try {
            // ulNoActions.g:63:5: ( ';' | identifier '=' expr ';' | identifier '[' expr ']' '=' expr ';' | expr ';' | IF '(' expr ')' block elseBlock | WHILE '(' expr ')' block | PRINT expr ';' | PRINTLN expr ';' | RETURN ( expr )? ';' )
            int alt7=9;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt7=1;
                }
                break;
            case ID:
                {
                int LA7_2 = input.LA(2);

                if ( (synpred2()) ) {
                    alt7=2;
                }
                else if ( (synpred3()) ) {
                    alt7=3;
                }
                else if ( (synpred4()) ) {
                    alt7=4;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("59:1: statement options {backtrack=true; } : ( ';' | identifier '=' expr ';' | identifier '[' expr ']' '=' expr ';' | expr ';' | IF '(' expr ')' block elseBlock | WHILE '(' expr ')' block | PRINT expr ';' | PRINTLN expr ';' | RETURN ( expr )? ';' );", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case ICONSTANT:
            case SCONSTANT:
            case FCONSTANT:
            case CCONSTANT:
            case TRUE:
            case FALSE:
            case 21:
                {
                alt7=4;
                }
                break;
            case IF:
                {
                alt7=5;
                }
                break;
            case WHILE:
                {
                alt7=6;
                }
                break;
            case PRINT:
                {
                alt7=7;
                }
                break;
            case PRINTLN:
                {
                alt7=8;
                }
                break;
            case RETURN:
                {
                alt7=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("59:1: statement options {backtrack=true; } : ( ';' | identifier '=' expr ';' | identifier '[' expr ']' '=' expr ';' | expr ';' | IF '(' expr ')' block elseBlock | WHILE '(' expr ')' block | PRINT expr ';' | PRINTLN expr ';' | RETURN ( expr )? ';' );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ulNoActions.g:63:7: ';'
                    {
                    match(input,26,FOLLOW_26_in_statement155); if (failed) return ;

                    }
                    break;
                case 2 :
                    // ulNoActions.g:64:7: identifier '=' expr ';'
                    {
                    pushFollow(FOLLOW_identifier_in_statement165);
                    identifier();
                    _fsp--;
                    if (failed) return ;
                    match(input,27,FOLLOW_27_in_statement167); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement169);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_statement171); if (failed) return ;

                    }
                    break;
                case 3 :
                    // ulNoActions.g:65:7: identifier '[' expr ']' '=' expr ';'
                    {
                    pushFollow(FOLLOW_identifier_in_statement181);
                    identifier();
                    _fsp--;
                    if (failed) return ;
                    match(input,28,FOLLOW_28_in_statement183); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement185);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,29,FOLLOW_29_in_statement187); if (failed) return ;
                    match(input,27,FOLLOW_27_in_statement189); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement191);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_statement193); if (failed) return ;

                    }
                    break;
                case 4 :
                    // ulNoActions.g:66:7: expr ';'
                    {
                    pushFollow(FOLLOW_expr_in_statement203);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_statement205); if (failed) return ;

                    }
                    break;
                case 5 :
                    // ulNoActions.g:67:7: IF '(' expr ')' block elseBlock
                    {
                    match(input,IF,FOLLOW_IF_in_statement215); if (failed) return ;
                    match(input,21,FOLLOW_21_in_statement217); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement219);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,22,FOLLOW_22_in_statement221); if (failed) return ;
                    pushFollow(FOLLOW_block_in_statement223);
                    block();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_elseBlock_in_statement225);
                    elseBlock();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 6 :
                    // ulNoActions.g:68:7: WHILE '(' expr ')' block
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_statement235); if (failed) return ;
                    match(input,21,FOLLOW_21_in_statement237); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement239);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,22,FOLLOW_22_in_statement241); if (failed) return ;
                    pushFollow(FOLLOW_block_in_statement243);
                    block();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 7 :
                    // ulNoActions.g:69:7: PRINT expr ';'
                    {
                    match(input,PRINT,FOLLOW_PRINT_in_statement253); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement255);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_statement257); if (failed) return ;

                    }
                    break;
                case 8 :
                    // ulNoActions.g:70:7: PRINTLN expr ';'
                    {
                    match(input,PRINTLN,FOLLOW_PRINTLN_in_statement267); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_statement269);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,26,FOLLOW_26_in_statement271); if (failed) return ;

                    }
                    break;
                case 9 :
                    // ulNoActions.g:71:7: RETURN ( expr )? ';'
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_statement281); if (failed) return ;
                    // ulNoActions.g:71:14: ( expr )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=ICONSTANT && LA6_0<=ID)||LA6_0==21) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ulNoActions.g:71:15: expr
                            {
                            pushFollow(FOLLOW_expr_in_statement284);
                            expr();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    match(input,26,FOLLOW_26_in_statement288); if (failed) return ;

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end statement


    // $ANTLR start elseBlock
    // ulNoActions.g:74:1: elseBlock : ( ELSE block )? ;
    public final void elseBlock() throws RecognitionException {
        try {
            // ulNoActions.g:74:10: ( ( ELSE block )? )
            // ulNoActions.g:74:12: ( ELSE block )?
            {
            // ulNoActions.g:74:12: ( ELSE block )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ELSE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ulNoActions.g:74:13: ELSE block
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_elseBlock303); if (failed) return ;
                    pushFollow(FOLLOW_block_in_elseBlock305);
                    block();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end elseBlock


    // $ANTLR start block
    // ulNoActions.g:77:1: block : '{' ( statement )* '}' ;
    public final void block() throws RecognitionException {
        try {
            // ulNoActions.g:77:6: ( '{' ( statement )* '}' )
            // ulNoActions.g:77:8: '{' ( statement )* '}'
            {
            match(input,24,FOLLOW_24_in_block319); if (failed) return ;
            // ulNoActions.g:77:12: ( statement )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=IF && LA9_0<=RETURN)||(LA9_0>=ICONSTANT && LA9_0<=ID)||LA9_0==21||LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ulNoActions.g:77:12: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block321);
            	    statement();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,25,FOLLOW_25_in_block324); if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end block


    // $ANTLR start expr
    // ulNoActions.g:80:1: expr : exprPart exprOP ;
    public final void expr() throws RecognitionException {
        try {
            // ulNoActions.g:80:5: ( exprPart exprOP )
            // ulNoActions.g:80:7: exprPart exprOP
            {
            pushFollow(FOLLOW_exprPart_in_expr336);
            exprPart();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_exprOP_in_expr338);
            exprOP();
            _fsp--;
            if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end expr


    // $ANTLR start exprPart
    // ulNoActions.g:83:1: exprPart : ( identifier | literal | identifier '[' expr ']' | identifier '(' exprList ')' | '(' expr ')' );
    public final void exprPart() throws RecognitionException {
        try {
            // ulNoActions.g:83:9: ( identifier | literal | identifier '[' expr ']' | identifier '(' exprList ')' | '(' expr ')' )
            int alt10=5;
            switch ( input.LA(1) ) {
            case ID:
                {
                switch ( input.LA(2) ) {
                case OP:
                case 22:
                case 23:
                case 26:
                case 29:
                    {
                    alt10=1;
                    }
                    break;
                case 21:
                    {
                    alt10=4;
                    }
                    break;
                case 28:
                    {
                    alt10=3;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("83:1: exprPart : ( identifier | literal | identifier '[' expr ']' | identifier '(' exprList ')' | '(' expr ')' );", 10, 1, input);

                    throw nvae;
                }

                }
                break;
            case ICONSTANT:
            case SCONSTANT:
            case FCONSTANT:
            case CCONSTANT:
            case TRUE:
            case FALSE:
                {
                alt10=2;
                }
                break;
            case 21:
                {
                alt10=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("83:1: exprPart : ( identifier | literal | identifier '[' expr ']' | identifier '(' exprList ')' | '(' expr ')' );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ulNoActions.g:83:11: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_exprPart350);
                    identifier();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // ulNoActions.g:84:9: literal
                    {
                    pushFollow(FOLLOW_literal_in_exprPart362);
                    literal();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // ulNoActions.g:85:9: identifier '[' expr ']'
                    {
                    pushFollow(FOLLOW_identifier_in_exprPart374);
                    identifier();
                    _fsp--;
                    if (failed) return ;
                    match(input,28,FOLLOW_28_in_exprPart376); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_exprPart378);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,29,FOLLOW_29_in_exprPart380); if (failed) return ;

                    }
                    break;
                case 4 :
                    // ulNoActions.g:86:9: identifier '(' exprList ')'
                    {
                    pushFollow(FOLLOW_identifier_in_exprPart392);
                    identifier();
                    _fsp--;
                    if (failed) return ;
                    match(input,21,FOLLOW_21_in_exprPart394); if (failed) return ;
                    pushFollow(FOLLOW_exprList_in_exprPart396);
                    exprList();
                    _fsp--;
                    if (failed) return ;
                    match(input,22,FOLLOW_22_in_exprPart398); if (failed) return ;

                    }
                    break;
                case 5 :
                    // ulNoActions.g:87:9: '(' expr ')'
                    {
                    match(input,21,FOLLOW_21_in_exprPart410); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_exprPart412);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    match(input,22,FOLLOW_22_in_exprPart414); if (failed) return ;

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end exprPart


    // $ANTLR start exprOP
    // ulNoActions.g:90:1: exprOP : ( OP expr exprOP )? ;
    public final void exprOP() throws RecognitionException {
        try {
            // ulNoActions.g:91:5: ( ( OP expr exprOP )? )
            // ulNoActions.g:91:7: ( OP expr exprOP )?
            {
            // ulNoActions.g:91:7: ( OP expr exprOP )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==OP) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ulNoActions.g:91:8: OP expr exprOP
                    {
                    match(input,OP,FOLLOW_OP_in_exprOP432); if (failed) return ;
                    pushFollow(FOLLOW_expr_in_exprOP434);
                    expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_exprOP_in_exprOP436);
                    exprOP();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end exprOP


    // $ANTLR start exprList
    // ulNoActions.g:94:1: exprList : expr ( exprMore )* ;
    public final void exprList() throws RecognitionException {
        try {
            // ulNoActions.g:94:9: ( expr ( exprMore )* )
            // ulNoActions.g:94:11: expr ( exprMore )*
            {
            pushFollow(FOLLOW_expr_in_exprList450);
            expr();
            _fsp--;
            if (failed) return ;
            // ulNoActions.g:94:16: ( exprMore )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ulNoActions.g:94:16: exprMore
            	    {
            	    pushFollow(FOLLOW_exprMore_in_exprList452);
            	    exprMore();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end exprList


    // $ANTLR start exprMore
    // ulNoActions.g:97:1: exprMore : ',' expr ;
    public final void exprMore() throws RecognitionException {
        try {
            // ulNoActions.g:97:9: ( ',' expr )
            // ulNoActions.g:97:11: ',' expr
            {
            match(input,23,FOLLOW_23_in_exprMore465); if (failed) return ;
            pushFollow(FOLLOW_expr_in_exprMore467);
            expr();
            _fsp--;
            if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end exprMore


    // $ANTLR start compoundType
    // ulNoActions.g:100:1: compoundType : ( type | type '[' ICONSTANT ']' );
    public final void compoundType() throws RecognitionException {
        try {
            // ulNoActions.g:100:14: ( type | type '[' ICONSTANT ']' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==TYPE) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==ID) ) {
                    alt13=1;
                }
                else if ( (LA13_1==28) ) {
                    alt13=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("100:1: compoundType : ( type | type '[' ICONSTANT ']' );", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("100:1: compoundType : ( type | type '[' ICONSTANT ']' );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ulNoActions.g:100:16: type
                    {
                    pushFollow(FOLLOW_type_in_compoundType480);
                    type();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // ulNoActions.g:101:9: type '[' ICONSTANT ']'
                    {
                    pushFollow(FOLLOW_type_in_compoundType492);
                    type();
                    _fsp--;
                    if (failed) return ;
                    match(input,28,FOLLOW_28_in_compoundType494); if (failed) return ;
                    match(input,ICONSTANT,FOLLOW_ICONSTANT_in_compoundType496); if (failed) return ;
                    match(input,29,FOLLOW_29_in_compoundType498); if (failed) return ;

                    }
                    break;

            }
        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end compoundType


    // $ANTLR start literal
    // ulNoActions.g:104:1: literal : ( SCONSTANT | ICONSTANT | FCONSTANT | CCONSTANT | TRUE | FALSE );
    public final void literal() throws RecognitionException {
        try {
            // ulNoActions.g:104:8: ( SCONSTANT | ICONSTANT | FCONSTANT | CCONSTANT | TRUE | FALSE )
            // ulNoActions.g:
            {
            if ( (input.LA(1)>=ICONSTANT && input.LA(1)<=FALSE) ) {
                input.consume();
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_literal0);    throw mse;
            }


            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end literal


    // $ANTLR start identifier
    // ulNoActions.g:107:1: identifier : ID ;
    public final void identifier() throws RecognitionException {
        try {
            // ulNoActions.g:107:12: ( ID )
            // ulNoActions.g:107:14: ID
            {
            match(input,ID,FOLLOW_ID_in_identifier543); if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end identifier


    // $ANTLR start type
    // ulNoActions.g:110:1: type : TYPE ;
    public final void type() throws RecognitionException {
        try {
            // ulNoActions.g:110:5: ( TYPE )
            // ulNoActions.g:110:7: TYPE
            {
            match(input,TYPE,FOLLOW_TYPE_in_type552); if (failed) return ;

            }

        }

                catch (RecognitionException ex) {
                        reportError(ex);
                        throw ex;
                }
        finally {
        }
        return ;
    }
    // $ANTLR end type

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // ulNoActions.g:64:7: ( identifier '=' expr ';' )
        // ulNoActions.g:64:7: identifier '=' expr ';'
        {
        pushFollow(FOLLOW_identifier_in_synpred2165);
        identifier();
        _fsp--;
        if (failed) return ;
        match(input,27,FOLLOW_27_in_synpred2167); if (failed) return ;
        pushFollow(FOLLOW_expr_in_synpred2169);
        expr();
        _fsp--;
        if (failed) return ;
        match(input,26,FOLLOW_26_in_synpred2171); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // ulNoActions.g:65:7: ( identifier '[' expr ']' '=' expr ';' )
        // ulNoActions.g:65:7: identifier '[' expr ']' '=' expr ';'
        {
        pushFollow(FOLLOW_identifier_in_synpred3181);
        identifier();
        _fsp--;
        if (failed) return ;
        match(input,28,FOLLOW_28_in_synpred3183); if (failed) return ;
        pushFollow(FOLLOW_expr_in_synpred3185);
        expr();
        _fsp--;
        if (failed) return ;
        match(input,29,FOLLOW_29_in_synpred3187); if (failed) return ;
        match(input,27,FOLLOW_27_in_synpred3189); if (failed) return ;
        pushFollow(FOLLOW_expr_in_synpred3191);
        expr();
        _fsp--;
        if (failed) return ;
        match(input,26,FOLLOW_26_in_synpred3193); if (failed) return ;

        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // ulNoActions.g:66:7: ( expr ';' )
        // ulNoActions.g:66:7: expr ';'
        {
        pushFollow(FOLLOW_expr_in_synpred4203);
        expr();
        _fsp--;
        if (failed) return ;
        match(input,26,FOLLOW_26_in_synpred4205); if (failed) return ;

        }
    }
    // $ANTLR end synpred4

    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_function_in_program25 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_functionDecl_in_function35 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_functionBody_in_function37 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_functionDecl46 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_functionDecl48 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionDecl50 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_formalParameters_in_functionDecl52 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionDecl54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_formalParameters64 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_formalParameters66 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_moreFormals_in_formalParameters68 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_moreFormals88 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_compoundType_in_moreFormals90 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_moreFormals92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_functionBody104 = new BitSet(new long[]{0x000000000627F9F0L});
    public static final BitSet FOLLOW_varDecl_in_functionBody106 = new BitSet(new long[]{0x000000000627F9F0L});
    public static final BitSet FOLLOW_statement_in_functionBody109 = new BitSet(new long[]{0x000000000623F9F0L});
    public static final BitSet FOLLOW_25_in_functionBody112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_varDecl121 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_varDecl123 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_varDecl125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_statement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_statement165 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_statement167 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement169 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_statement181 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement183 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement185 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_statement187 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_statement189 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement191 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_statement203 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement215 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_statement217 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement219 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_statement221 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_in_statement223 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_elseBlock_in_statement225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_statement235 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_statement237 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement239 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_statement241 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_in_statement243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_statement253 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement255 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINTLN_in_statement267 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_statement269 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_statement281 = new BitSet(new long[]{0x000000000423F800L});
    public static final BitSet FOLLOW_expr_in_statement284 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseBlock303 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_in_elseBlock305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_block319 = new BitSet(new long[]{0x000000000623F9F0L});
    public static final BitSet FOLLOW_statement_in_block321 = new BitSet(new long[]{0x000000000623F9F0L});
    public static final BitSet FOLLOW_25_in_block324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprPart_in_expr336 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_exprOP_in_expr338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_exprPart350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_exprPart362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_exprPart374 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_exprPart376 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_exprPart378 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_exprPart380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_exprPart392 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_exprPart394 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_exprList_in_exprPart396 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_exprPart398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_exprPart410 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_exprPart412 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_exprPart414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OP_in_exprOP432 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_exprOP434 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_exprOP_in_exprOP436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_exprList450 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_exprMore_in_exprList452 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_exprMore465 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_exprMore467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_compoundType480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_compoundType492 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_compoundType494 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ICONSTANT_in_compoundType496 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_compoundType498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_type552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred2165 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_synpred2167 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_synpred2169 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_synpred2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred3181 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3183 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_synpred3185 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_synpred3187 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_synpred3189 = new BitSet(new long[]{0x000000000023F800L});
    public static final BitSet FOLLOW_expr_in_synpred3191 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_synpred3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred4203 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_synpred4205 = new BitSet(new long[]{0x0000000000000002L});

}