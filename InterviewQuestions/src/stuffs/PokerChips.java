package stuffs;

import java.util.ArrayList;
import java.util.Arrays;

public class PokerChips {

    /*
    def pokerChips(chips):
    C = [0]
    T = sum(chips) / len(chips)
    for i in xrange(1, len(chips)):
        C.append(C[-1] + chips[i]  - T)
    C.sort()
    res = 0
    for c in C:
        res += abs(c - C[len(C) / 2])
    return res
     */

    public static void main(String[] args) {
        PokerChips pokerChips = new PokerChips();
        int i = pokerChips.pokerChips(new int[]{1, 5, 9, 10, 5});
        System.out.println(i);
    }

    int pokerChips(int[] chips) {
        final int[] moves = {0};
        ArrayList<Integer> chipsList = new ArrayList<>();
        chipsList.add(0);
        int mean = Arrays.stream(chips).sum() / chipsList.size();
        for (int i = 0; i < chips.length; i++) {
            int c = chipsList.get(chipsList.size() - 1) + chips[i] - mean;
            chipsList.add(c);
        }
        chipsList.sort(Integer::compare);
        chipsList.stream().forEach(integer -> moves[0] += Math.abs(integer - chipsList.get(chipsList.size() / 2)));
        return moves[0];
    }
}
