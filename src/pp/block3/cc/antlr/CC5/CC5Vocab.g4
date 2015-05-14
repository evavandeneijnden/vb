lexer grammar CC5Vocab;

@header{package pp.block3.cc.antlr.CC5;}

MINUS  : '-';
POWER  : '^';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;

// ignore whitespace
WS : [ \t\n\r] -> skip;