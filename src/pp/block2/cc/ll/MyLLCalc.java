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
        int iterationsSinceChange = 0;


        for (Term t : grammar.getTerminals()) {
            System.out.println(t);
            Set<Term> temp = new HashSet<>();
            temp.add(t);
            first.put(t, temp);
        }

        for (NonTerm nt: grammar.getNonterminals()){
            Set<Term> temp = new HashSet<>();
            first.put(nt,temp);
        }
        while (iterationsSinceChange < first.size()){
            for (Rule r : grammar.getRules()){
                Set<Term> rhs = new HashSet<>();
                int i = -1;
                int k = r.getRHS().size();
                if (k > 1){
                    rhs = first.get(r.getRHS().get(0));
                    i = 0;

                    while (first.get(r.getRHS().get(i)).contains(Symbol.EMPTY) && i<k-1){
                        rhs.addAll(first.get(r.getRHS().get(i+1)));
                        if (rhs.contains(Symbol.EMPTY)){
                            rhs.remove(Symbol.EMPTY);
                        }
                        i++;
                    }
                }
                else {
                    if (first.get(r.getRHS().get(k)).contains(Symbol.EMPTY) && i+1==k){
                        rhs.add(Symbol.EMPTY);
                    }
                }
            }


            iterationsSinceChange ++;
        }



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
