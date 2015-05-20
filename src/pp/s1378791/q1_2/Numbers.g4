lexer grammar Numbers;

@header{package pp.s1378791.q1_2;}

LONG_BINARY         : INT_BINARY        LONG;
LONG_OCTAL          : INT_OCTAL         LONG;
LONG_DECIMAL        : INT_DECIMAL       LONG;
LONG_HEXADECIMAL    : INT_HEXADECIMAL   LONG;

INT_BINARY          : ZERO B BIT;
INT_OCTAL           : ZERO (ZERO|OCT);
INT_DECIMAL         : ZERO | INT;
INT_HEXADECIMAL     : ZERO X HEX;

fragment LONG : [lL];
fragment BIT  : [01]+;
fragment OCT  : [1-7][0-7]+;
fragment INT  : [1-9][0-9]*;
fragment HEX  : [0-9a-fA-F]+;
fragment ZERO : '0';
fragment X    : 'x';
fragment B    : 'b';