package pp.block2.cc.test;

import org.junit.Test;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LLCalcTest {
	/** Tests the LL-calculator for the Sentence grammar. */
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
		// FOLLOW sets
		assertEquals(set(Symbol.EOF), calc.getFollow().get(sent));
		assertEquals(set(verb), calc.getFollow().get(subj));
		assertEquals(set(end), calc.getFollow().get(obj));
		assertEquals(set(noun, adj), calc.getFollow().get(mod));
		// is-LL1-test
		assertFalse(calc.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		return new MyLLCalc(g); // your implementation of LLCalc
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
