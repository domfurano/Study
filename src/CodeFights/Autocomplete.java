package CodeFights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Autocomplete {
    public static void main(String[] args) {
        Autocomplete autocomplete = new Autocomplete();
//        if (!Arrays.deepEquals(autocomplete.autocomplete(new String[]{"under", "understand", "understanding", "understandable", "unacceptable", "undeniable", "unilateral", "universe", "universal", "underestimated", "understated"},
//                new String[]{"u", "n", "PAUSE", "d", "e", "PAUSE", "r", "s", "t", "a", "PAUSE", "t", "e", "PAUSE"}), new String[][]
//                {{"unacceptable", "undeniable", "under", "underestimated", "understand", "understandable", "understanding", "understated", "unilateral", "universal", "universe"},
//                        {"undeniable", "under", "underestimated", "understand", "understandable", "understanding", "understated"},
//                        {"understand", "understandable", "understanding", "understated"},
//                        {"understated"}})) throw new AssertionError();
        if (!Arrays.deepEquals(autocomplete.autocomplete(new String[]{"all", "of", "the", "words"},
                new String[]{"PAUSE"}), new String[][]
                {{"all", "of", "the", "words"}})) throw new AssertionError();

    }

    private String[][] autocomplete(String[] wordList, String[] actions) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> wList = new ArrayList<>(Arrays.asList(wordList));
        ArrayList<String> aList = new ArrayList<>(Arrays.asList(actions));

        Stack<String> currentWord = new Stack<>();

        for (String action : aList) {
            if (action.equals("BACKSPACE")) {
                currentWord.pop();
            } else if (action.equals("PAUSE")) {
                result.add(wList.stream()
                        .filter(s -> s.startsWith(currentWord.stream().reduce(String::concat).orElse("")))
                        .sorted()
                        .collect(Collectors.toCollection(ArrayList::new)));
            } else {
                currentWord.push(action);
            }
        }

        String[][] resultArray = new String[result.size()][];

        IntStream.range(0, result.size()).forEach(i -> {
            resultArray[i] = new String[result.get(i).size()];
            IntStream.range(0, result.get(i).size()).forEach(j -> resultArray[i][j] = result.get(i).get(j));

        });

        return resultArray;
    }


}
