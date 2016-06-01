package pp.block3.cc.tabular;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
//import org.antlr.v4.runtime.misc.Nullable;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by antoine on 13/05/15.
 */
public class MyListener extends BaseErrorListener {

    List<String> errors;

    public MyListener() {
        super();
        errors = new LinkedList<>();
    }

//    @Override
//    public void syntaxError(@NotNull Recognizer<?, ?> recognizer, @Nullable Object offendingSymbol, int line, int charPositionInLine, @NotNull String msg, @Nullable RecognitionException e) {
//        errors.add(String.format("line %d:%d %s", line, charPositionInLine, msg));
//    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        errors.add(String.format("line %d - %d Ambiguity", startIndex, stopIndex));
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        errors.add(String.format("line %d - %d Attempting Full Context", startIndex, stopIndex));
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        errors.add(String.format("line %d - %d Context Sensitivity", startIndex, stopIndex));
    }

    public List<String> getErrors() {
        return errors;
    }
}

