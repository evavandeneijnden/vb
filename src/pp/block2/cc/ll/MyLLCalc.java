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
        Map<Map<NonTerm, Term>, Set<Rule>> resultMap = new HashMap<>();
        for (NonTerm nt : grammar.getNonterminals()) {
            for (Term t : grammar.getTerminals()) {
                Set<Rule> emptySet = new HashSet<>();
                Map<NonTerm, Term> map = new HashMap<>();
                map.put(nt, t);
                resultMap.put(map, emptySet);
            }
            for (Rule r : grammar.getRules()) {
                for (Term t : firstp.get(r)) {
                    Map<NonTerm, Term> tempMap = new HashMap<>();
                    tempMap.put(nt, t);
                    Set<Rule> tableValues = resultMap.get(tempMap);
                    tableValues.add(r);
                    resultMap.remove(tempMap);
                    resultMap.put(tempMap, tableValues);
                }
                if (firstp.get(r).contains(Symbol.EOF)) {
                    Map<NonTerm, Term> tempMap = new HashMap<>();
                    tempMap.put(nt, Symbol.EOF);
                    Set<Rule> tableValues = resultMap.get(tempMap);
                    tableValues.add(r);
                    resultMap.remove(tempMap);
                    resultMap.put(tempMap, tableValues);
                }
            }
        }

        boolean result = true;
        for (Map<NonTerm, Term> tableEntry : resultMap.keySet()) {
            int noOfEntries = resultMap.get(tableEntry).size();
            if (noOfEntries != 1) {
                result = false;
            }
        }

        return result;
    }
}
