package pp.block1.cc.dfa;

public class MyChecker implements Checker {


    public boolean accepts(State start, String word) {
        boolean result;

        if (word == ""){
            result = false;
        }
        else {
            for (int i = 0; i < word.length()-1 ; i++){
                char currentChar = word.charAt(i);

                if (start.hasNext(currentChar)) {
                    start = start.getNext(currentChar);
                }
                else {
                    result = false;
                    break;
                }
            }

            // We are now considering the final character of the word
            int index = word.length()-1;
            char character = word.charAt(index);
            State last = start.getNext(character);
            if (last != null && last.isAccepting()){
                result = true;
            }
            else {
                result = false;
            }
        }
        return result;
    }



}