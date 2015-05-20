package pp.s1378791.q1_5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by antoine on 13/05/15.
 */
public class MySymbolTable {

    LinkedList<Map<String,String>> scope;

    public MySymbolTable() {
        scope = new LinkedList<>();
        openScope();
    }

    public void openScope() {
        scope.push(new HashMap<String, String>());
    }

    public void closeScope() {
        Map<String,String> temp = scope.pop();
        if (scope.isEmpty()) {
            scope.push(temp);
            throw new RuntimeException();
        }
    }

    public boolean add(String id, String type) {
        String temp = scope.peek().put(id,type);
        boolean result = null == temp;
        if (!result) {
            scope.peek().put(id,temp);
        }
        return result;
    }

    public boolean sameType(String a, String b) {
        String a_type = null;
        String b_type = null;
        Iterator<Map<String,String>> iterator = scope.iterator();
        while ((a_type == null || b_type == null) && iterator.hasNext()) {
            Map<String,String> next = iterator.next();
            if (a_type == null)
                a_type = next.get(a);
            if (b_type == null)
                b_type = next.get(b);
        }
        return a_type != null && a_type.equals(b_type);
    }
}
