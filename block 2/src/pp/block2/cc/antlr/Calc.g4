grammar Calc;

expr: addition;
addition: multiplication (po multiplication)*;
multiplication: negation (MO negation)*;
negation : (MIN)* power;
power: <assoc=right> (base POWO)* base;
base: '(' expr ')'
    | N;

po : PLUS
    | MIN
    ;

N: '0'..'9'+;
POWO : '^';
MO : '*';
PLUS : '+';
MIN : '-';
