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
    : '{' (vd=varDecl { it.addVarDecl(vd); })* (st=statement{
            if(st != null){
                it.addStatement(st);
            }
                                                })* '}'
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
      id=identifier '[' exp=expr ']' '=' exp2=expr ';' {st = new ArrayAssignStatement(id,exp,exp2);} |
      exp=expr ';' {st=new ExprStatement(exp);} |
      IF '(' exp=expr ')' bl=block ebl=elseBlock {return new IfStatement(exp,bl,ebl);} |
      WHILE '(' exp=expr ')' bl=block { st = new WhileStatement(exp,bl);} |
      PRINT exp=expr ';' {st = new PrintStatement(exp);}|
      PRINTLN exp=expr ';' {st = new PrintlnStatement(exp);} |
      RETURN (exp=expr)? f=';' {st = new ReturnStatement(exp, $f.line, $f.pos);}
      ;

elseBlock returns [Block block]
@init{
    Block it = null;
}
@after{
    block = it;
}
    : (ELSE bl=block{it=bl;})?
    ;

block returns [Block block]
@init{
    Block it = new Block();
}
@after{
    block = it;
}
    : '{' (st=statement{it.addStatement(st);})* '}'
  ;

expr returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprOP1 {it = ex1;} (o='==' ex2=exprOP1 {it = new EqualsExpr(it,ex2,$o.line,$o.pos); })*
  ;

exprPart returns [Expr expr]:
        id=identifier {expr = id;} |
        l=literal {expr = l;} |
        id=identifier '[' exp=expr ']' {expr = new ArrayReference(id,exp);} |
        id=identifier '(' el=exprList ')' {expr = new FunctionCall(id,el);} |
        '(' e=expr ')' { expr = new ParenExpr(e); }
    ;

exprOP1 returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprOP2 {it = ex1;} (o='<' ex2=exprOP2 {it = new LessThanExpr(it,ex2, $o.line,$o.pos); })*
    ;

exprOP2 returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprOP3 {it=ex1;}
        ((o='+' ex2=exprOP3 {it=new AddExpr(it,ex2,$o.line,$o.pos);}) | (o='-' ex2=exprOP3){it=new SubtractExpr(it,ex2,$o.line, $o.pos);})*
    ;

exprOP3 returns [Expr exp]
@init{
    Expr it = null;
}
@after{
    exp = it;
}
    : ex1=exprPart {it=ex1;}
        (o='*' ex2=exprPart {it = new MultExpr(it,ex2,$o.line,$o.pos);})*
    ;

exprList returns [ExprList exprs]
@init{
    ExprList it = new ExprList();
}
@after{
    exprs = it;
}
    : (e=expr {it.add(e);} (em=exprMore {it.add(em);})*)?
    ;

exprMore returns [Expr expr]: ',' e=expr {expr=e;}
    ;

compoundType returns [Type ct]: t=TYPE
        { ct = TypeFactory.getType($t.text, $t.line, $t.pos); } |
        t=TYPE '[' i=ICONSTANT ']'
        { ct = TypeFactory.getArrayType($t.text, Integer.parseInt($i.text), $t.line, $t.pos); }
    ;

literal returns [Literal literal]:
        s=SCONSTANT {literal = new StringLiteral($s.text, $s.line, $s.pos);} |
        i=ICONSTANT {literal = new IntegerLiteral(Integer.parseInt($i.text), $i.line, $i.pos);}|
        f=FCONSTANT {literal = new FloatLiteral(Float.parseFloat($f.text), $f.line, $f.pos);}|
        c=CCONSTANT {literal = new CharLiteral($c.text, $c.line, $c.pos);}|
        b=TRUE {literal = new BooleanLiteral(true,$b.line,$b.pos);}|
        b=FALSE {literal = new BooleanLiteral(false,$b.line,$b.pos);}
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

/*
EQUALITY: '==';
ADD: '+';
SUBTRACT: '-';
LESSTHAN: '<';
MULTIPLY: '*';
*/


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
