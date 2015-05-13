package pp.block3.cc.symbol;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by antoine on 13/05/15.
 */
public class MySymbolTable implements SymbolTable {

    LinkedList<Set<String>> scope;

    public MySymbolTable() {
        scope = new LinkedList<>();
        openScope();
    }

    @Override
    public void openScope() {
        scope.push(new HashSet<String>());
    }

    @Override
    public void closeScope() {
        Set<String> temp = scope.pop();
        if (scope.isEmpty()) {
            scope.push(temp);
            throw new RuntimeException();
        }
    }

    @Override
    public boolean add(String id) {
        return scope.peek().add(id);
    }

    @Override
    public boolean contains(String id) {
        boolean result = false;
        Iterator<Set<String>> iterator = scope.iterator();
        while (!result && iterator.hasNext()) {
            result = iterator.next().contains(id);
        }
        return result;
    }
}
