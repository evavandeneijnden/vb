package pp.block1.cc.dfa;

/**
 * Created by Eva on 22/04/2015.
 */
public class IdChecker implements Checker {

    public boolean accepts(State start, String word) {
        State currentState = start;
        boolean result;
        for (char letter : word.toCharArray()) {
            currentState = currentState.getNext(letter);
            if (currentState == null)
                break;
        }
        result = currentState != null && currentState.isAccepting();
        return result;
    }
}
