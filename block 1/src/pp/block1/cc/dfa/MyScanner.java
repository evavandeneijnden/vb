package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;


public class MyScanner implements Scanner {

    public List<String> scan(State dfa, String text) {
        List<String> result = new ArrayList<String>();
        State currentState = dfa;
        int startIndexToken = -1;
        String intermediateResult = "";
        int lastTokenIndex = -1;


        for (int i = 0; i < text.length(); i++){


            if (currentState == dfa){
                startIndexToken = i;
            }
            currentState = currentState.getNext(text.charAt(i));


            if (currentState.isAccepting()){
                intermediateResult = text.substring(startIndexToken, i + 1);
                lastTokenIndex = i;
            }
            if ( i < text.length() -1 && !currentState.hasNext(text.charAt(i + 1))){
                if (intermediateResult != ""){
                    result.add(intermediateResult);
                    currentState = dfa;
                    i = lastTokenIndex;
                }
            }
            else  if (i >= text.length()-1 && currentState.isAccepting()){
                    result.add(intermediateResult);
                    currentState = dfa;
                    i = lastTokenIndex;
            }
        }
        return result;
    }
}
