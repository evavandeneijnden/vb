/**
 *
 */
package pp.s1378791.q1_3;

import pp.block2.cc.NonTerm;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;

/**
 * Class containing some example grammars.
 *
 * @author Arend Rensink
 */
public class Grammars {


    //grammar BNF_SIMPLE;
//
//@header{package pp.s1378791.q1_3;}
//
//        e : f eh;
//        eh : PLS e | MNS e;
//        f : LP fh | g;
//        fh : ID RP f | e RP;
//        g : a gh;
//        gh : LBRACK e RBRACK gh | POINT ID gh;
//        a : NUM | ID;
//
//        NUM     : [0-9]+;
//        ID      : [a-zA-Z0-9]+;
//        PLS     : '+';
//        MNS     : '-';
//        LP      : '(';
//        RP      : ')';
//        LBRACK  : '[';
//        RBRACK  : ']';
//        POINT   : '.';


    public static Grammar makeBNFSimple(){
        NonTerm e  = new NonTerm("E");
        NonTerm eh = new NonTerm("EH");
        NonTerm f  = new NonTerm("F");
        NonTerm fh = new NonTerm("FH");
        NonTerm g  = new NonTerm("F");
        NonTerm gh  = new NonTerm("F");
        NonTerm a  = new NonTerm("F");

        SymbolFactory fact = new SymbolFactory(BNF_SIMPLELexer.class);
        Term num    = fact.getTerminal(BNF_SIMPLEParser.NUM);
        Term id     = fact.getTerminal(BNF_SIMPLEParser.ID);
        Term pls    = fact.getTerminal(BNF_SIMPLEParser.PLS);
        Term mns    = fact.getTerminal(BNF_SIMPLEParser.MNS);
        Term lp     = fact.getTerminal(BNF_SIMPLEParser.LP);
        Term rp     = fact.getTerminal(BNF_SIMPLEParser.RP);
        Term lbrack = fact.getTerminal(BNF_SIMPLEParser.LBRACK);
        Term rbrack = fact.getTerminal(BNF_SIMPLEParser.RBRACK);
        Term point  = fact.getTerminal(BNF_SIMPLEParser.POINT);


        Grammar grammar = new Grammar(e);
        grammar.addRule(e,f,eh);
        grammar.addRule(eh,pls,e);
        grammar.addRule(eh,mns,e);
        grammar.addRule(f,lp,fh);
        grammar.addRule(f,g);
        grammar.addRule(fh,id,rp,f);
        grammar.addRule(fh,e,rp);
        grammar.addRule(g,a,gh);
        grammar.addRule(gh,lbrack,e,rbrack,gh);
        grammar.addRule(gh,point,id,gh);
        grammar.addRule(a,num);
        grammar.addRule(a,id);
        return grammar;
    }
}
