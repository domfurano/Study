package recursion;

/*
function combinations(str) {
    var fn = function(active, rest, a) {
        if (!active && !rest)
            return;
        if (!rest) {
            a.push(active);
        } else {
            fn(active + rest[0], rest.slice(1), a);
            fn(active, rest.slice(1), a);
        }
        return a;
    }
    return fn("", str, []);
}
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations<T> {

    public static void main(String[] args) {
        Combinations<String> combinations = new Combinations<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
//        strings.add("E");
//        strings.add("F");
        System.out.println(combinations.combinations(strings));
    }

    public ArrayList<ArrayList<T>> combinations(ArrayList<T> list) {
        return combinate(new ArrayList<>(), list, new ArrayList<>());
    }

    private ArrayList<ArrayList<T>> combinate(ArrayList<T> active, List<T> rest, ArrayList<ArrayList<T>> accumulator) {
        if (active.isEmpty() && rest.isEmpty()) {
            return accumulator;
        }
        if (rest.isEmpty()) {
            accumulator.add(active);
        } else {
            ArrayList<T> activeA = new ArrayList<>(active);
            activeA.add(rest.get(0));

            List<T> subRest = rest.subList(1, rest.size());
            combinate(activeA, subRest, accumulator);
            combinate(active, subRest, accumulator);

        }
        return accumulator;
    }

}
