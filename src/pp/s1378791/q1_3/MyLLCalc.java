package pp.s1378791.q1_3;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.LLCalc;
import pp.block2.cc.ll.Rule;

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

        for (NonTerm nt : grammar.getNonterminals()) {
            follow.put(nt, new HashSet<Term>());
        }

        follow.get(grammar.getStart()).add(Symbol.EOF);

        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (Rule r : grammar.getRules()) {
                int k = r.getRHS().size();
                Set<Term> trailer = new HashSet<>(follow.get(r.getLHS()));

                for (int i = k; 0 < i; i--) {
                    Symbol b = r.getRHS().get(i - 1);
                    if (b instanceof NonTerm) {
                        Set<Term> fa = follow.get(b);
                        int temp = fa.size();
                        fa.addAll(trailer);
                        hasChanged |= temp != fa.size();

                        Set<Term> bFirst = new HashSet<>(first.get(b));
                        if (first.get(b).contains(Symbol.EMPTY)) {
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
        Map<Rule, Set<Term>> firstP = new HashMap<>();

        for (Rule r : grammar.getRules()) {
            Symbol firstSymbol = r.getRHS().get(0);
            Set<Term> firstFirst = first.get(firstSymbol);
            if (firstFirst.contains(Symbol.EMPTY)) {
                Set<Term> temp = new HashSet<>(follow.get(r.getLHS()));
                temp.addAll(firstFirst);
                temp.remove(Symbol.EMPTY);
                firstP.put(r, temp);
            } else {
                firstP.put(r, firstFirst);
            }
        }
        return firstP;
    }

    @Override
    public boolean isLL1() {
        Map<Rule, Set<Term>> firstp = getFirstp();
        for (NonTerm nt : grammar.getNonterminals()) {
            HashMap<Term, Rule> ntmap = new HashMap<>();
            for (Rule r : grammar.getRules(nt)) {
                for (Term t : firstp.get(r)) {
                    if (ntmap.containsKey(t))
                        return false;
                    ntmap.put(t, r);
                }
                if (firstp.get(r).contains(Symbol.EOF)) {
                    if (ntmap.containsKey(Symbol.EOF))
                        return false;
                    ntmap.put(Symbol.EOF, r);
                }
            }
        }

        return true;
    }
}
