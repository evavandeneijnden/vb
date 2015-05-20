grammar BNF;

@header{package pp.s1378791.q1_3;}

e : e (PLS | MNS) f | f;
f : LP ID RP f | g;
g : g (LBRACK e RBRACK | POINT ID) | a;
a : LP e RP | NUM | ID;

NUM     : [0-9]+;
ID      : [a-zA-Z0-9]+;
PLS     : '+';
MNS     : '-';
LP      : '(';
RP      : ')';
LBRACK  : '[';
RBRACK  : ']';
POINT   : '.';
