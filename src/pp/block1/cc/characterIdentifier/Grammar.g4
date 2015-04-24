lexer grammar Grammar;
@header {package pp.block1.cc.characterIdentifier;}

fragment LETTER: 'a'..'z' | 'A'..'Z';
fragment ALFANUM : '0'..'9' | LETTER;

IDENTIFIER: LETTER ALFANUM ALFANUM ALFANUM ALFANUM ALFANUM;
