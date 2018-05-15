package combination;

public class Str237Iterative {
    public static void main(String[] args) {
        System.out.println(str237("Hello World!!"));
    }

    static int str237(String s) {
        int chars[] = new int[500];
        for (byte c : s.getBytes()) {
            for (int i = 237; i-- > 0;) {
                if (i > 0) {
                    chars[i + c] += chars[i];
                } else {
                    chars[i + c] += 1;
                }
            }
        }
        return chars[237];
    }
}
