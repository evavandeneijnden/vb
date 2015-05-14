grammar Tex;

@header{package pp.block3.cc.tabular;}

table : beginTable row+ endTable;

beginTable : '\\begin{tabular}{' ARGUMENT '}' WS;
ARGUMENT : [lcr] + ;

row : ENTRY WS? ('&' WS? ENTRY WS?)* '\\\\' WS;
ENTRY : [a-zA-Z0-9]* ;

endTable : '\\end{tabular}' WS;

COMMENT : '%' .*? [\n\r]+ -> skip;
WS : [ \t\n\r]+ ;
