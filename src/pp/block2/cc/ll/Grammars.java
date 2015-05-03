/**
 *
 */
package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 *
 * @author Arend Rensink
 */
public class Grammars {
    /**
     * Returns a grammar for simple English sentences.
     */
    public static Grammar makeSentence() {
        // Define the non-terminals
        NonTerm sent = new NonTerm("Sentence");
        NonTerm subj = new NonTerm("Subject");
        NonTerm obj = new NonTerm("Object");
        NonTerm mod = new NonTerm("Modifier");
        // Define the terminals, using the Sentence.g4 lexer grammar
        SymbolFactory fact = new SymbolFactory(Sentence.class);
        Term noun = fact.getTerminal(Sentence.NOUN);
        Term verb = fact.getTerminal(Sentence.VERB);
        Term adj = fact.getTerminal(Sentence.ADJECTIVE);
        Term end = fact.getTerminal(Sentence.ENDMARK);
        // Build the context free grammar
        Grammar g = new Grammar(sent);
        g.addRule(sent, subj, verb, obj, end);
        g.addRule(subj, noun);
        g.addRule(subj, mod, subj);
        g.addRule(obj, noun);
        g.addRule(obj, mod, obj);
        g.addRule(mod, adj);
        return g;
    }

    public static Grammar makeIfStatement() {
        // NT
        NonTerm stat = new NonTerm("Stat");
        NonTerm elsePart = new NonTerm("ElsePart");

        // T
        SymbolFactory term = new SymbolFactory(If.class);
        Term assign = term.getTerminal(If.ASSIGN);
        Term ifTerm = term.getTerminal(If.IF);
        Term expr = term.getTerminal(If.COND);
        Term then = term.getTerminal(If.THEN);
        Term elseTerm = term.getTerminal(If.ELSE);

        // G
        Grammar g = new Grammar(stat);
        g.addRule(stat, assign);
        g.addRule(stat, ifTerm, expr, then, stat, elsePart);
        g.addRule(elsePart, elseTerm, stat);
        g.addRule(elsePart, Symbol.EMPTY);
        return g;
    }
}
