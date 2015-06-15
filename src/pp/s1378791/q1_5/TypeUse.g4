grammar TypeUse;

@header{package pp.s1378791.q1_5;}

program : '(' series ')' ;
series  : unit* ;
unit    : decl | assign | '(' series ')' ;
decl    : ID ':' ID ';' ;
assign  : ID ':=' ID ';' ;

ID : [a-zA-Z]+;
WS : [ \t\n\r]+ -> skip;
