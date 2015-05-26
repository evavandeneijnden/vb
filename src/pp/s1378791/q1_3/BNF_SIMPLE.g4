grammar BNF_SIMPLE;

@header{package pp.s1378791.q1_3;}

// Klopt nog niet helemaal...

e : f eh;
eh : PLS e | MNS e;
f : LP fh | g;
fh : ID RP f | e RP;
g : a gh;
gh : LBRACK e RBRACK gh | POINT ID gh;
a : NUM | ID;

NUM     : [0-9]+;
ID      : [a-zA-Z0-9]+;
PLS     : '+';
MNS     : '-';
LP      : '(';
RP      : ')';
LBRACK  : '[';
RBRACK  : ']';
POINT   : '.';
