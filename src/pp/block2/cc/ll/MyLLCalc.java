package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by antoine on 29/04/15.
 */
public class MyLLCalc implements LLCalc {
    private Grammar grammar;

    public MyLLCalc(Grammar g) {
        grammar = g;
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        Map<Symbol, Set<Term>> first = new HashMap<>();
        for (Term t : grammar.getTerminals()) {
            System.out.println(t);
            Set<Term> temp = new HashSet<>();
            temp.add(t);
            first.put(t, temp);
        }
//        Term eof = new Term();


        return null;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        return null;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        return null;
    }

    @Override
    public boolean isLL1() {
        return false;
    }
}
