package pp.block1.cc.dfa;

import java.util.Map;
import java.util.TreeMap;

/**
 * State of a DFA.
 */
public class State {
	/**
	 * Constructs a new, possibly accepting state with a given number. The
	 * number is meant to identify the state, but there is no check for
	 * uniqueness.
	 */
	public State(int nr, boolean accepting) {
		this.next = new TreeMap<>();
		this.nr = nr;
		this.accepting = accepting;
	}

	/** Returns the state number. */
	public int getNumber() {
		return nr;
	}

	/** State number */
	private final int nr;

	/** Indicates if the state is accepting. */
	public boolean isAccepting() {
		return accepting;
	}

	/** Flag indicating if this state is accepting. */
	private final boolean accepting;

	/**
	 * Adds an outgoing transition to a next state. This overrides any previous
	 * transition for that character.
	 */
	public void addNext(Character c, State next) {
		this.next.put(c, next);
	}

	/** Indicates if there is a next state for a given character. */
	public boolean hasNext(Character c) {
		return getNext(c) != null;
	}

	/**
	 * Returns the (possibly <code>null</code>) next state for a given
	 * character.
	 */
	public State getNext(Character c) {
		return next.get(c);
	}

	/** Mapping to next states. */
	private final Map<Character, State> next;

	@Override
	public String toString() {
		String trans = "";
		for (Map.Entry<Character, State> out : next.entrySet()) {
			if (!trans.isEmpty()) {
				trans += ", ";
			}
			trans += "--" + out.getKey() + "-> " + out.getValue().getNumber();
		}
		return String.format("State %d (%s) with outgoing transitions %s", nr,
				accepting ? "accepting" : "not accepting", trans);
	}

	static final public State ID6_DFA;
	static {
		ID6_DFA = new State(0, false);
		State id61 = new State(1, false);
		State id62 = new State(2, false);
		State id63 = new State(3, false);
		State id64 = new State(4, false);
		State id65 = new State(5, false);
		State id66 = new State(5, true);
		State[] states = { ID6_DFA, id61, id62, id63, id64, id65, id66 };
		for (char c = 'a'; c < 'z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = 'A'; c < 'Z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = '0'; c < '9'; c++) {
			for (int s = 1; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
	}
	static final public State DFA_LALA;
	static {
		DFA_LALA = new State(1,true);
		State la1_1 = new State(11,false);
		State la1_2 = new State(12,true);
		State la1_3 = new State(13,true);
		State la2_1 = new State(21,false);
		State la2_2 = new State(22,true);
		State la2_3 = new State(23,true);
		State la3_1 = new State(31,false);
		State la3_2 = new State(32,false);
		State la3_3 = new State(33,false);
		State li1 = new State(51,false);
		State li2 = new State(52,true);

//		State[] states = {DFA_LALA,la1_1,la1_2,la1_3,la2_1,la2_2,la2_3,la3_1,la3_2,la3_3,li1,li2};

		DFA_LALA.addNext('L',la1_1);
		la1_1.addNext('a',la1_2);
		la1_2.addNext('a',la1_2);
		la1_2.addNext(' ',la1_3);
		la1_3.addNext(' ',la1_3);
		la1_2.addNext('L',la2_1);
		la1_3.addNext('L',la2_1);

		la2_1.addNext('a',la2_2);
		la2_2.addNext('a',la2_2);
		la2_2.addNext(' ',la2_3);
		la2_3.addNext(' ',la2_3);
		la2_2.addNext('L',la3_1);
		la2_3.addNext('L',la3_1);

		la3_1.addNext('a',la3_2);
		la3_2.addNext('a',la3_2);
		la3_2.addNext(' ',la3_3);
		la3_3.addNext(' ',la3_3);
		la3_2.addNext('L',li1);
		la3_3.addNext('L',li1);

		li1.addNext('i',li2);
		li2.addNext(' ',li2);
	}
}
