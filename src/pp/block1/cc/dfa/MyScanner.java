package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;


public class MyScanner implements Scanner {

    public List<String> scan(State dfa, String text) {
        List<String> result = new ArrayList<String>();
        State currentState = dfa;

        for (int i = 0; i < text.length(); i++){
            String intermediateResult = "";

            if (currentState.isAccepting()){
                intermediateResult = text.substring(0, i-1);
            }
            if (!currentState.hasNext(text.charAt(i))){
                if (intermediateResult != ""){
                    result.add(intermediateResult);
                    currentState = dfa;
                }
            }
        }
        return result;
    }
}
