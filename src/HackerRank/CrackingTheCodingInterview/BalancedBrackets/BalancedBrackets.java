package HackerRank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) throws IOException {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        if (!balancedBrackets.balanced("{[()]}")) throw new AssertionError();
        if (balancedBrackets.balanced("{[(])}")) throw new AssertionError();
        if (!balancedBrackets.balanced("{{[[(())]]}}")) throw new AssertionError();
        if (balancedBrackets.balanced("][(]}})(")) throw new AssertionError();

        ArrayList<String> testInputs = new ArrayList<>();
        ArrayList<String> testOutputs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/z002m1n/PersonalProjects/Study/src/HackerRank/bb_test_input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                testInputs.add(line);
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/z002m1n/PersonalProjects/Study/src/HackerRank/bb_test_output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                testOutputs.add(line);
            }
        }
        for (int i = 0; i < testInputs.size(); i++) {
            String input = testInputs.get(i);
            boolean expected = testOutputs.get(i).equals("YES");
            boolean output = balancedBrackets.balanced(input);
            if (expected != output) {
                throw new AssertionError();
            }
        }
    }

    private boolean balanced(String s) {
        Stack<Character> bracketStack = new Stack<>();

        boolean balanced = true;
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                bracketStack.push(bracket);
            } else {
                if (bracketStack.empty()) {
                    balanced = false;
                    break;
                } else {
                    char top = bracketStack.pop();
                    if (top == '(' && bracket != ')' || top == '[' && bracket != ']' || top == '{' && bracket != '}') {
                        balanced = false;
                        break;
                    }
                }
            }
        }

        return balanced && bracketStack.empty();
    }
}
