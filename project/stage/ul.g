grammar ul;

@header{
    import AST.*;
    import Type.*;
}

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

program returns [Program p]
@init
{
    p = new Program();
}
    : (f=function
            { p.addFunction(f); }
       )+ EOF
	;

function returns [Function f]
    : fd=functionDecl fb=functionBody
        { f = new Function(fd,fb); }
	;

functionDecl returns [FunctionDecl fd]
    : ct=compoundType id=identifier '(' pl=formalParameters ')'
        {
            fd = new FunctionDecl(ct, id, pl);
        }
	;

functionBody returns [FunctionBody fb]
@init{
    FunctionBody it = new FunctionBody();
}
@after{
    fb = it;
}
    : '{' (vd=varDecl { it.addVarDecl(vd); })* (st=statement{it.addStatement(st);})* '}'
	;

formalParameters returns [ParameterList params]
@init{
    ParameterList it = new ParameterList();
}
@after{
    params = it;
}
    : (
        type=compoundType id=identifier { it.add(new Parameter(type,id)); }
             (param=moreFormals {it.add(param);})*
      )?
    ;

moreFormals returns [Parameter param]: ',' type=compoundType id=identifier {param = new Parameter(type,id);}
    ;

varDecl returns [VarDecl vd]: type=compoundType id=identifier ';' {vd = new VarDecl(type,id);}
    ;

statement returns [Statement st]
options {
    backtrack=true;
}
    : ';' |
      id=identifier '=' exp=expr ';' { st = new AssignStatement(id,exp); } |
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

expr returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprOP1 {it = ex1;} ('==' ex2=exprOP1 {it = new EqualsExpr(it,ex2); })*
    ;

exprPart returns [Expr expr]: id=identifier {expr = id;} |
        literal |
        identifier '[' expr ']' |
        identifier '(' exprList ')' |
        '(' expr ')'
    ;

exprOP1 returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprOP2 {it = ex1;} ('<' ex2=exprOP2 {it = new LessThanExpr(it,ex2); })*
    ;

exprOP2 returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprOP3 {it=ex1;}
        (('+' ex2=exprOP3 {it=new AddExpr(it,exp);}) | ('-' ex2=exprOP3){it=new SubtractExpr(it,exp);})*
    ;

exprOP3 returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprPart {it=ex1;}
        ('*' ex2=exprPart {it = new MultExpr(it,ex2);})*
    ;

exprList: (expr exprMore*)?
    ;

exprMore: ',' expr
    ;

compoundType returns [Type ct]: t=TYPE
        { ct = TypeFactory.getType($t.text, $t.line, $t.pos); } |
        t=TYPE '[' i=ICONSTANT ']'
        { ct = TypeFactory.getArrayType($t.text, Integer.parseInt($i.text), $t.line, $t.pos); }
    ;

literal: SCONSTANT | ICONSTANT | FCONSTANT | CCONSTANT | TRUE | FALSE
    ;

identifier returns [Identifier id]: name=ID { id = new Identifier($name.text, $name.line, $name.pos); }
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

TYPE: 'int'|'float'|'char'|'string'|'boolean'|'void'
	;

ID	: ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*
	;

/*
OP  : ('*'|'+'|'-'|'<'|'==')
    ;
*/

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

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n' | EOF) { $channel = HIDDEN;}
    ;
