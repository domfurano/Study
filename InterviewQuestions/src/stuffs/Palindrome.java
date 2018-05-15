package stuffs;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        if (!palindrome.isPalindrome("")) throw new AssertionError();
        if (!palindrome.isPalindrome("a")) throw new AssertionError();
        if (!palindrome.isPalindrome("aa")) throw new AssertionError();
        if (!palindrome.isPalindrome("aba")) throw new AssertionError();
        if (!palindrome.isPalindrome("abcba")) throw new AssertionError();
        if (palindrome.isPalindrome("ab")) throw new AssertionError();
        if (palindrome.isPalindrome("abc")) throw new AssertionError();
        if (palindrome.isPalindrome("abcd")) throw new AssertionError();
        if (palindrome.isPalindrome("abca")) throw new AssertionError();
        System.out.println("All tests passed!");
    }

    boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int mid = chars.length / 2;
        int i = 0;
        int j = chars.length - 1;
        while (i <= mid && j >= mid) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
