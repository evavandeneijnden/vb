grammar CC5;
import CC5Vocab;

term  : term POWER term    #hat
      | term PLUS term     #plus
      | term EQUALS term   #equals
      | LPAR term RPAR     #parentheses
      | NUM                #num
      | BOOL               #bool
      | STR                #str
      ;