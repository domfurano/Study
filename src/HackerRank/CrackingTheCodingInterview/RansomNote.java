package HackerRank.CrackingTheCodingInterview;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        if (!ransomNote.canMakeRansom(new String[]{"give", "me", "one", "grand", "today", "night"},
                new String[]{"give", "one", "grand", "today"})) {
            throw new AssertionError();
        }
        if (ransomNote.canMakeRansom(new String[]{"two", "times", "three", "is", "not", "four"},
                new String[]{"two", "times", "two", "is", "four"})) {
            throw new AssertionError();
        }
    }

    private boolean canMakeRansom(String[] magazine, String[] ransom) {
        HashMap<String, Integer> magazineMap = new HashMap<>();
        for (String s : magazine) {
            if (!magazineMap.containsKey(s)) {
                magazineMap.put(s, 1);
            } else {
                magazineMap.put(s, magazineMap.get(s) + 1);
            }
        }
        for (String s : ransom) {
            if (!magazineMap.containsKey(s)) {
                return false;
            } else {
                int count = magazineMap.get(s);
                if (count < 1) {
                    return false;
                }
                magazineMap.put(s, count - 1);
            }
        }
        return true;
    }
}
