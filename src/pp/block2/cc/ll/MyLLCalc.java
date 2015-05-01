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
        boolean hasChanged = true;


        for (Term t : grammar.getTerminals()) {
            System.out.println(t);
            Set<Term> temp = new HashSet<>();
            temp.add(t);
            first.put(t, temp);
        }

        for (NonTerm nt : grammar.getNonterminals()) {
            first.put(nt, new HashSet<Term>());
        }

        while (hasChanged) {
            hasChanged = false;
            for (Rule r : grammar.getRules()) {
                Set<Term> rhs = new HashSet<>();
                int i = -1;
                int k = r.getRHS().size();
                if (k > 1) {
                    rhs = first.get(r.getRHS().get(0));
                    i = 0;

                    while (first.get(r.getRHS().get(i)).contains(Symbol.EMPTY) && i < k - 1) {
                        int temp = rhs.size();
                        rhs.addAll(first.get(r.getRHS().get(i + 1)));
                        hasChanged |= temp != rhs.size();
                        if (rhs.contains(Symbol.EMPTY)) {
                            rhs.remove(Symbol.EMPTY);
                        }
                        i++;
                    }
                } else {
                    if (first.get(r.getRHS().get(k)).contains(Symbol.EMPTY) && i + 1 == k) {
                        rhs.add(Symbol.EMPTY);
                    }
                }
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
            int k = follow.size();
            for (Rule r : grammar.getRules()) {

                trailer = follow.get(r.getLHS());
                for (int i = k; 0 <= i; i--) {
                    Symbol b = r.getRHS().get(i);
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

            }
        }

        return getFirstp();
    }

    @Override
    public boolean isLL1() {
        return false;
    }
}
