package HackerRank.CrackingTheCodingInterview;

import java.util.*;

public class MakingAnagrams {
    public static void main(String[] args) {
        MakingAnagrams makingAnagrams = new MakingAnagrams();
        if (makingAnagrams.makeAnagrams("cde", "abc") != 4) throw new AssertionError();
        if (makingAnagrams.makeAnagrams("c", "c") != 0) throw new AssertionError();
        if (makingAnagrams.makeAnagrams("", "") != 0) throw new AssertionError();
        if (makingAnagrams.makeAnagrams("abc", "bce") != 2) throw new AssertionError();
        if (makingAnagrams.makeAnagrams("ifjerky", "poopje") != 9) throw new AssertionError();
        if (makingAnagrams.makeAnagrams("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke") != 30)
            throw new AssertionError();
    }

    private int makeAnagrams(String a, String b) {
        int deletions = 0;

        HashMap<Character, Integer> characterCounts = new HashMap<>();
        for (char c : a.toCharArray()) {
            if (!characterCounts.containsKey(c)) {
                characterCounts.put(c, 1);
            } else {
                characterCounts.put(c, characterCounts.get(c) + 1);
            }
        }
        for (char c : b.toCharArray()) {
            if (!characterCounts.containsKey(c)) {
                characterCounts.put(c, -1);
            } else {
                characterCounts.put(c, characterCounts.get(c) - 1);
            }
        }

        for (int i : characterCounts.values()) {
            deletions += Math.abs(i);
        }

        return deletions;
    }

    private int deletions(String a, String b) {
        int[] ints = new int[26];
        int deletions = 0;
        for (int i = 0; i < a.length(); ++i) {
            ints[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); ++i) {
            ints[b.charAt(i) - 'a']--;
        }
        for (int i : ints) {
            deletions += Math.abs(i);
        }
        return deletions;
    }
}
