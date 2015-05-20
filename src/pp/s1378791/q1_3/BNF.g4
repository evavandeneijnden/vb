grammar BNF;

@header{package pp.s1378791.q1_3;}

e : e (PLUS | MINUS) f | f;
f : LPAR ID RPAR f | g;
g : g (LBRACKET e RBRACKET | POINT ID) | a;
a : LPAR e RPAR | NUM | ID;

NUM : [0-9]+;
ID  : [a-zA-Z0-9]+;