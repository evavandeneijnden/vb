package pp.block2.cc.test;

import org.junit.Test;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class LLCalcTest {
    /**
     * Tests the LL-calculator for the Sentence grammar.
     */

    @Test
    public void testSentence() {
        Grammar g = Grammars.makeSentence();

        // Without the last (recursive) rule, the grammar is LL-1
        assertTrue(createCalc(g).isLL1());
        NonTerm subj = g.getNonterminal("Subject");
        NonTerm obj = g.getNonterminal("Object");
        NonTerm sent = g.getNonterminal("Sentence");
        NonTerm mod = g.getNonterminal("Modifier");
        g.addRule(mod, mod, mod);
        LLCalc calc = createCalc(g);

        // FIRST sets
        Term adj = g.getTerminal(Sentence.ADJECTIVE);
        Term noun = g.getTerminal(Sentence.NOUN);
        Term verb = g.getTerminal(Sentence.VERB);
        Term end = g.getTerminal(Sentence.ENDMARK);
        assertEquals(set(adj, noun), calc.getFirst().get(sent));
        assertEquals(set(adj, noun), calc.getFirst().get(subj));
        assertEquals(set(adj, noun), calc.getFirst().get(obj));
        assertEquals(set(adj), calc.getFirst().get(mod));
        System.out.println("first done");

        // FOLLOW sets
        assertEquals(set(Symbol.EOF), calc.getFollow().get(sent));
        assertEquals(set(verb), calc.getFollow().get(subj));
        assertEquals(set(end), calc.getFollow().get(obj));
        assertEquals(set(noun, adj), calc.getFollow().get(mod));
        System.out.println("follow done");

        // Firstp
        assertEquals(set(noun), calc.getFirstp().get(g.getRules(subj).get(0)));
        assertEquals(set(noun), calc.getFirstp().get(g.getRules(obj).get(0)));
        assertEquals(set(adj), calc.getFirstp().get(g.getRules(mod).get(0)));
        assertEquals(set(adj, noun), calc.getFirstp().get(g.getRules(sent).get(0)));
        assertEquals(set(adj), calc.getFirstp().get(g.getRules(subj).get(1)));
        assertEquals(set(noun), calc.getFirstp().get(g.getRules(obj).get(0)));
        assertEquals(set(adj), calc.getFirstp().get(g.getRules(obj).get(1)));
        System.out.println("FirstP done");

        // is-LL1-test
        assertFalse(calc.isLL1());
    }

    @Test
    public void testIf() {
        Grammar g = Grammars.makeIfStatement();

        // NT
        NonTerm stat = g.getNonterminal("Stat");
        NonTerm elsePart = g.getNonterminal("ElsePart");

        // T
        Term ifT = g.getTerminal(If.IF);
        Term then = g.getTerminal(If.THEN);
        Term cond = g.getTerminal(If.COND);
        Term elseT = g.getTerminal(If.ELSE);
        Term assign = g.getTerminal(If.ASSIGN);
        Term eof = Symbol.EOF;
        Term empty = Symbol.EMPTY;

        LLCalc calc = createCalc(g);

        //FIRST
        Map<Symbol, Set<Term>> first = calc.getFirst();
        assertEquals(set(assign, ifT), first.get(stat));
        assertEquals(set(elseT, empty), first.get(elsePart));

        //FOLLOW
        assertEquals(set(eof, elseT), calc.getFollow().get(stat));
        assertEquals(set(eof, elseT), calc.getFollow().get(elsePart));

        //FIRSTP
        assertEquals(set(assign), calc.getFirstp().get(g.getRules(stat).get(0)));
        assertEquals(set(ifT), calc.getFirstp().get(g.getRules(stat).get(1)));
        assertEquals(set(elseT), calc.getFirstp().get(g.getRules(elsePart).get(0)));
        assertEquals(set(eof, elseT), calc.getFirstp().get(g.getRules(elsePart).get(1)));

        assertFalse(calc.isLL1());
    }


    @Test
    public void testABC() {
        Grammar g = Grammars.makeABCshizzle();

        // T
        Term a = g.getTerminal(ABC.A);
        Term b = g.getTerminal(ABC.B);
        Term c = g.getTerminal(ABC.C);
        Term eof = Symbol.EOF;

        // NT
        NonTerm l = g.getNonterminal("L");
        NonTerm r = g.getNonterminal("R");
        NonTerm p = g.getNonterminal("P");
        NonTerm o = g.getNonterminal("O");

        LLCalc calc = createCalc(g);

        //FIRST
        assertEquals(set(a, c, b), calc.getFirst().get(l));
        assertEquals(set(a, c), calc.getFirst().get(r));

        //FOLLOW
        assertEquals(set(eof), calc.getFollow().get(l));
        assertEquals(set(a), calc.getFollow().get(r));

        //FIRSTP
        assertEquals(set(a, c), calc.getFirstp().get(g.getRules(l).get(0)));
        assertEquals(set(b), calc.getFirstp().get(g.getRules(l).get(1)));
        assertEquals(set(a), calc.getFirstp().get(g.getRules(r).get(0)));
        assertEquals(set(c), calc.getFirstp().get(g.getRules(r).get(1)));

        assertTrue(calc.isLL1());
    }

    /**
     * Creates an LL1-calculator for a given grammar.
     */
    private LLCalc createCalc(Grammar g) {
        return new MyLLCalc(g); // your implementation of LLCalc
    }

    @SuppressWarnings("unchecked")
    private <T> Set<T> set(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }
}
