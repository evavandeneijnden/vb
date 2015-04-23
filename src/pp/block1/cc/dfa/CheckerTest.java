package pp.block1.cc.dfa;

import org.junit.Assert;
import org.junit.Test;

import static pp.block1.cc.dfa.State.DFA_LALA;
import static pp.block1.cc.dfa.State.ID6_DFA;

/** Test class for Checker implementation. */
public class CheckerTest {
	private Checker myChecker = new IdChecker(); // instantiate your Checker implementation

	@Test
	public void testID6() {
		dfa = ID6_DFA;
		accepts("a12345");
		rejects("");
		rejects("a12 45");
		rejects("a12 456");
		rejects("a123456");
		rejects("123456");
	}

	@Test
	public void testLALALALALALALA(){
		dfa = DFA_LALA;
		accepts("La");
		accepts("La La");
		rejects("La La Li");
		rejects("La Li");
		rejects("La La La La Li");
		rejects("La Li");
		rejects("Li");
		rejects("La La La");
		accepts("");
		rejects("La La La La");
		accepts("Laaaaaaaa");
		accepts("La La La Li");
		accepts("Laaaa    La LaaaaaaLi");
	}


	private void accepts(String word) {
		if (!myChecker.accepts(dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously rejected by %s", word, dfa));
		}
	}

	private void rejects(String word) {
		if (myChecker.accepts(dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously accepted by %s", word, dfa));
		}
	}

	private State dfa;
}
