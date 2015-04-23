package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antoine on 22/04/15.
 */
public class IdGenerator implements Generator {

    @Override
    public List<String> scan(State dfa, String text) {
        List<String> result = new ArrayList<>();
        String lastFoundRest = text;

        while (0 < lastFoundRest.length()) {
            State currentState = dfa;
            text = lastFoundRest;
            String lastFound = null;
            lastFoundRest = "";

            for (int index = 0; index < text.length(); index++) {
                currentState = currentState.getNext(text.charAt(index));
                if (currentState == null)
                    break;
                else if (currentState.isAccepting()) {
                    lastFoundRest = text.substring(index+1);
                    lastFound = text.substring(0,index+1);
                }
            }

            if (lastFound != null) {
                result.add(lastFound);
            } else {
                return null;
            }
        }

        return result;
    }
}
