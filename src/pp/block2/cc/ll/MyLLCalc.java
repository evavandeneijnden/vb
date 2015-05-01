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
            Set<Term> temp = new HashSet<>();
            temp.add(t);
            first.put(t, temp);
        }

        for (NonTerm nt : grammar.getNonterminals()) {
            first.put(nt, new HashSet<Term>());
        }

        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (Rule r : grammar.getRules()) {
                Set<Term> lhs = first.get(r.getLHS());
                Set<Term> rhs = new HashSet<>(first.get(r.getRHS().get(0)));
                rhs.remove(Symbol.EMPTY);

                int i = 1;
                int k = r.getRHS().size();

                while (first.get(r.getRHS().get(i - 1)).contains(Symbol.EMPTY) && i < k) {
                    rhs.addAll(first.get(r.getRHS().get(i)));
                    if (rhs.contains(Symbol.EMPTY)) {
                        rhs.remove(Symbol.EMPTY);
                    }
                    i++;
                }
                if (i == k && first.get(r.getRHS().get(k - 1)).contains(Symbol.EMPTY)) {
                    rhs.add(Symbol.EMPTY);
                }
                int temp = lhs.size();
                lhs.addAll(rhs);
                hasChanged |= temp != lhs.size();
            }
        }
        return first;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        Map<Symbol, Set<Term>> first = getFirst();
        Map<NonTerm, Set<Term>> follow = new HashMap<>();
        boolean hasChanged = true;

        for (NonTerm nt : grammar.getNonterminals()) {
            follow.put(nt, new HashSet<Term>());
        }

        follow.get(grammar.getStart()).add(Symbol.EOF);

        while (hasChanged) {
            hasChanged = false;
            Set<Term> trailer = new HashSet<>();
            for (Rule r : grammar.getRules()) {
                int k = r.getRHS().size();
                trailer = new HashSet<>(follow.get(r.getLHS()));

                for (int i = k; 0 < i; i--) {
                    Symbol b = r.getRHS().get(i-1);
                    if (b instanceof NonTerm) {
                        int temp = follow.get(b).size();
                        follow.get(b).addAll(trailer);
                        hasChanged |= temp == follow.get(b).size();

                        Set<Term> bFirst = new HashSet<>(first.get(b));
                        if (bFirst.contains(Symbol.EMPTY)) {
                            bFirst.remove(Symbol.EMPTY);
                            trailer.addAll(bFirst);
                        } else {
                            trailer = bFirst;
                        }
                    } else {
                        trailer = new HashSet<>(first.get(b));
                    }
                }

            }
        }
        return follow;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        Map<NonTerm, Set<Term>> follow = getFollow();
        Map<Symbol, Set<Term>> first = getFirst();
        Map<Rule,Set<Term>> firstP = new HashMap<>();

        for (Rule r: grammar.getRules()){

            Symbol firstSymbol = r.getRHS().get(0);
            if (r.getRHS().contains(Symbol.EMPTY)){
                Set<Term> temp = new HashSet<>();
                temp.addAll(first.get(firstSymbol));
                temp.addAll(follow.get(firstSymbol));
                firstP.put(r, temp);
            }
            else {
                firstP.put(r,first.get(firstSymbol));
            }
        }

        return firstP;
    }

    @Override
    public boolean isLL1() {
        Map<NonTerm, Set<Rule>> resultMap = new HashMap<>();
        for (NonTerm nt: grammar.getNonterminals()){
            Set<Rule> row = new HashSet<>();
            for (Term t: grammar.getTerminals()){

            }
        }
        return false;
    }
}
