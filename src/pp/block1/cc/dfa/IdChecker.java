package pp.block1.cc.dfa;

/**
 * Created by Eva on 22/04/2015.
 */
public class IdChecker implements Checker{

    public boolean accepts(State start, String word){
        State currentState = start;
        boolean result;
        for (int i = 0; i<word.length()-1; i++){
           currentState =  currentState.getNext(word.charAt(i));
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
