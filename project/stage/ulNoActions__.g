lexer grammar ulNoActions;

T21 : '(' ;
T22 : ')' ;
T23 : ',' ;
T24 : '{' ;
T25 : '}' ;
T26 : ';' ;
T27 : '=' ;
T28 : '[' ;
T29 : ']' ;

// $ANTLR src "ulNoActions.g" 115
IF	: 'if'
	;

// $ANTLR src "ulNoActions.g" 118
ELSE: 'else'
	;

// $ANTLR src "ulNoActions.g" 121
TRUE : 'true'
    ;

// $ANTLR src "ulNoActions.g" 124
FALSE : 'false'
    ;

// $ANTLR src "ulNoActions.g" 127
WHILE: 'while'
    ;

// $ANTLR src "ulNoActions.g" 130
PRINT: 'print'
    ;

// $ANTLR src "ulNoActions.g" 133
PRINTLN: 'println'
    ;

// $ANTLR src "ulNoActions.g" 136
RETURN: 'return'
    ;

/* Fixme: add the other types here */
// $ANTLR src "ulNoActions.g" 140
TYPE	: 'int'|'float'|'char'|'string'|'boolean'|'void'
	;
/*
 * FIXME:
 * Change this to match the specification for identifier
 *
 */
// $ANTLR src "ulNoActions.g" 147
ID	: ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*
	;

// $ANTLR src "ulNoActions.g" 150
OP  : ('+'|'-'|'<'|'*'|'==')
    ;

// $ANTLR src "ulNoActions.g" 153
SCONSTANT : ('"')('_'|'a'..'z'|'A'..'Z'|'0'..'9'|' ')*('"')
    ;

// $ANTLR src "ulNoActions.g" 156
CCONSTANT : ('\'')('_'|'a'..'z'|'A'..'Z'|'0'..'9'|' ')('\'')
    ;

// $ANTLR src "ulNoActions.g" 159
ICONSTANT : ('0'..'9')+
    ;

// $ANTLR src "ulNoActions.g" 162
FCONSTANT : ('0'..'9')+('.')('0'..'9')+
    ;

/* These two lines match whitespace and comments
 * and ignore them.
 * You want to leave these as last in the file.
 * Add new lexical rules above
 */
// $ANTLR src "ulNoActions.g" 170
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
    ;


// $ANTLR src "ulNoActions.g" 174
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
    ;
