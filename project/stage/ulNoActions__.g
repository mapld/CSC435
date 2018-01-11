lexer grammar ulNoActions;

T20 : '(' ;
T21 : ')' ;
T22 : ',' ;
T23 : '{' ;
T24 : '}' ;
T25 : ';' ;
T26 : '=' ;
T27 : '[' ;
T28 : ']' ;
T29 : '==' ;
T30 : '<' ;
T31 : '+' ;
T32 : '-' ;
T33 : '*' ;

// $ANTLR src "ulNoActions.g" 110
IF	: 'if'
	;

// $ANTLR src "ulNoActions.g" 113
ELSE: 'else'
	;

// $ANTLR src "ulNoActions.g" 116
TRUE : 'true'
    ;

// $ANTLR src "ulNoActions.g" 119
FALSE : 'false'
    ;

// $ANTLR src "ulNoActions.g" 122
WHILE: 'while'
    ;

// $ANTLR src "ulNoActions.g" 125
PRINT: 'print'
    ;

// $ANTLR src "ulNoActions.g" 128
PRINTLN: 'println'
    ;

// $ANTLR src "ulNoActions.g" 131
RETURN: 'return'
    ;

/* Fixme: add the other types here */
// $ANTLR src "ulNoActions.g" 135
TYPE	: 'int'|'float'|'char'|'string'|'boolean'|'void'
	;
/*
 * FIXME:
 * Change this to match the specification for identifier
 *
 */
// $ANTLR src "ulNoActions.g" 142
ID	: ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*
	;

/*
OP  : ('*'|'+'|'-'|'<'|'==')
    ;
*/

// $ANTLR src "ulNoActions.g" 150
SCONSTANT : ('"')('_'|'a'..'z'|'A'..'Z'|'0'..'9'|' ')*('"')
    ;

// $ANTLR src "ulNoActions.g" 153
CCONSTANT : ('\'')('_'|'a'..'z'|'A'..'Z'|'0'..'9'|' ')('\'')
    ;

// $ANTLR src "ulNoActions.g" 156
ICONSTANT : ('0'..'9')+
    ;

// $ANTLR src "ulNoActions.g" 159
FCONSTANT : ('0'..'9')+('.')('0'..'9')+
    ;

/* These two lines match whitespace and comments
 * and ignore them.
 * You want to leave these as last in the file.
 * Add new lexical rules above
 */
// $ANTLR src "ulNoActions.g" 167
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
    ;


// $ANTLR src "ulNoActions.g" 171
COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
    ;
