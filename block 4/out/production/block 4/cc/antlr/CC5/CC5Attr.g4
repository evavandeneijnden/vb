grammar CC5Attr;

import CC5Vocab;
@header { import cc.antlr.Type;}

@members {
    private int getValue(String text) {
        return Integer.parseInt(text);
    }
}


term returns [ Type type ]
    : term0 = term POWER term1 = term
        {   if ($term0.type == Type.NUM && $term1.type == Type.NUM){
               $type = Type.NUM;
            }
            else if ($term0.type == Type.STR && $term1.type == Type.NUM) {
                    $type = Type.STR;
             }
             else {
                $type = Type.ERR;
             }
        }
     | term0 = term PLUS term1 = term
        {   if ($term0.type == Type.NUM && $term1.type == Type.NUM){
             $type = Type.NUM;
            }
            else if ($term0.type == Type.BOOL && $term1.type == Type.BOOL){
                $type = Type.BOOL;
            }
            else if ($term0.type == Type.STR && $term1.type == Type.STR){
                            $type = Type.STR;
                        }
            else {
                $type = Type.ERR;
            }
        }
     | term0 = term EQUALS term1 = term
        {   if ($term0.type == Type.NUM && $term1.type == Type.NUM){
              $type = Type.BOOL;
           }
           else  if ($term0.type == Type.BOOL && $term1.type == Type.BOOL){
              $type = Type.BOOL;
           }
            else  if ($term0.type == Type.STR && $term1.type == Type.STR){
                 $type = Type.BOOL;
            }
            else {
                $type = Type.ERR;
            }
        }

      | LPAR term0=term RPAR
        {$type = $term0.type;}
      | NUM
        {$type = Type.NUM;}
      | BOOL
        {$type = Type.BOOL;}
      | STR
        {$type = Type.STR;}
      ;