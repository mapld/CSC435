grammar ulNoActions;


@members
{
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
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}

/*
 * This is a subset of the ulGrammar to show you how
 * to make new production rules.
 * You will need to:
 *  - change type to be compoundType and include appropriate productions
 *  - introduce optional formalParameters
 *  - change functionBody to include variable declarations and statements 
 */

program: function+
	;

function: functionDecl functionBody
	;

functionDecl: compoundType identifier '(' formalParameters ')'
	;

formalParameters: (compoundType identifier moreFormals*)
    |
    ;

moreFormals: ',' compoundType identifier
    ;

functionBody: '{' varDecl* statement* '}'
	;

varDecl: compoundType identifier ';'
    ;

statement
options {
    backtrack=true;
}
    : ';' |
      identifier '=' expr ';' |
      identifier '[' expr ']' '=' expr ';' |
      expr ';' |
      IF '(' expr ')' block elseBlock |
      WHILE '(' expr ')' block |
      PRINT expr ';' |
      PRINTLN expr ';' |
      RETURN (expr)? ';'
      ;

elseBlock: (ELSE block)?
    ;

block: '{' statement* '}'
    ;

expr: exprPart exprOP
    ;

exprPart: identifier |
        literal |
        identifier '[' expr ']' |
        identifier '(' exprList ')' |
        '(' expr ')'
    ;

exprOP
    : (OP expr exprOP)?
    ;

exprList: expr exprMore*
    ;

exprMore: ',' expr
    ;

compoundType : type |
        type '[' ICONSTANT ']'
    ;

literal: SCONSTANT | ICONSTANT | FCONSTANT | CCONSTANT | TRUE | FALSE
    ;

identifier : ID
	;

type:	TYPE
	;

/* Lexer */

IF	: 'if'
	;

ELSE: 'else'
	;

TRUE : 'true'
    ;

FALSE : 'false'
    ;

WHILE: 'while'
    ;

PRINT: 'print'
    ;

PRINTLN: 'println'
    ;

RETURN: 'return'
    ;

/* Fixme: add the other types here */
TYPE	: 'int'|'float'|'char'|'string'|'boolean'|'void'
	;
/*
 * FIXME:
 * Change this to match the specification for identifier
 *
 */
ID	: ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*
	;

OP  : ('+'|'-'|'<'|'*'|'==')
    ;

SCONSTANT : ('"')('_'|'a'..'z'|'A'..'Z'|'0'..'9'|' ')*('"')
    ;

CCONSTANT : ('\'')('_'|'a'..'z'|'A'..'Z'|'0'..'9'|' ')('\'')
    ;

ICONSTANT : ('0'..'9')+
    ;

FCONSTANT : ('0'..'9')+('.')('0'..'9')+
    ;

/* These two lines match whitespace and comments
 * and ignore them.
 * You want to leave these as last in the file.
 * Add new lexical rules above
 */
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
    ;


COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
    ;
