package HackerRank;

import java.util.LinkedList;

public class MakingAnagrams {
    public static void main(String[] args) {
        MakingAnagrams makingAnagrams = new MakingAnagrams();
        System.out.println(makingAnagrams.makeAnagrams("cde", "abc"));
    }

    private int makeAnagrams(String a, String b) {
        int deletions = 0;

        LinkedList<Character> aList = new LinkedList<>();
        LinkedList<Character> bList = new LinkedList<>();

        for (char c : a.toCharArray()) {
            aList.add(c);
        }

        for (char c : b.toCharArray()) {
            bList.add(c);
        }

        aList.sort(Character::compareTo);
        bList.sort(Character::compareTo);

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex != aList.size() - 1 || bIndex != bList.size() - 1) {
            Character _a = aList.get(aIndex);
            Character _b = bList.get(bIndex);

            if (_a.compareTo(_b) == 0) {
                if (aIndex < aList.size() - 1) {
                    aIndex++;
                }
                if (bIndex < bList.size() - 1) {
                    bIndex++;
                }
            } else if (_a.compareTo(_b) < 0) {
//                aList.remove(aIndex);
                aIndex++;
                deletions++;
            } else if (_a.compareTo(_b) > 0) {
//                bList.remove(bIndex);
                bIndex++;
                deletions++;
            }
        }

        return deletions;
    }
}
