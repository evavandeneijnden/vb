package pp.block1.cc.dfa;

/**
 * Created by Eva on 22/04/2015.
 */
public class IdChecker {

    public boolean accepts(State start, String word){
        State currentState = start;
        boolean result;
        for (int i = 0; i<word.length(); i++){
           currentState =  currentState.getNext(i);
        }
        if (currentState.isAccepting()){
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
