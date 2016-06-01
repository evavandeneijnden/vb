lexer grammar CC5Vocab;

MINUS  : '-';
POWER  : '^';
LPAR   : '(';
RPAR   : ')';

EQUALS : '==';
BOOL : 'false'
     | 'true'
     ;
PLUS : '+';

STR : [a-z | A-Z]+;

NUM : [0-9]+;

// ignore whitespace
WS : [ \t\n\r] -> skip;