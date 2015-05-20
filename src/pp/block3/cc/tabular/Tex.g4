grammar Tex;

@header{package pp.block3.cc.tabular;}

table   : WS? beginTable row+ endTable WS?;

beginTable : BS BEGIN LB TABULAR RB LB ARGUMENT RB WS;

row     : ( WS? (ENTRY WS?)? AND)* WS? (ENTRY WS?)? BS BS WS;

endTable : BS END LB TABULAR RB;

ARGUMENT : [lcr] + ;
COMMENT : '%' .*? [\n\r]+ -> skip;
WS      : [ \t\n\r]+ ;
BS      : [\\];
LB      : [{];
RB      : [}];
AND     : [&];
TABULAR : 'tabular';
BEGIN   : 'begin';
END     : 'end';
ENTRY   : [a-zA-Z0-9]([a-zA-Z0-9 ]*[a-zA-Z0-9])? ;
