package InterviewQuestions.Codibility;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();

        if (demo.solution(new int[]{1, 3, 6, 4, 1, 2}) != 5) throw new AssertionError();
        if (demo.solution(new int[]{1, 2, 3}) != 4) throw new AssertionError();
        if (demo.solution(new int[]{-1, -3}) != 1) throw new AssertionError();

    }

    public int solution(int[] A) {
        HashSet<Integer> integers = new HashSet<Integer>();
        for (int a : A) {
            integers.add(a);
        }
        for (int i = 1; i <= 100000; i++) {
            if (!integers.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
