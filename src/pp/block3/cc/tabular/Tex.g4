grammar Tex;

@header{package pp.block3.cc.symbol;}

table : beginTable row+ endTable;

beginTable : '\\begin{tabular}{' argument '}' WS;
argument : (LEFT | CENTERED | RIGHT) + ;
LEFT : 'l';
CENTERED : 'c';
RIGHT : 'r';

row : ENTRY WS ('&' WS ENTRY WS)* '\\\\' WS;
ENTRY : [a-zA-Z0-9]+ ;

endTable : '\\end{tabular}' WS;

COMMENT : '%' .*? [\n\r] -> skip;
WS : [ \t\n\r]+ ;
