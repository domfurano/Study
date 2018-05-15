package noRepeating;

/**
 * Created by calvin on 3/5/16.
 */
public class NoRepeats {

    String noRepeatingCharacters(String s) {
        char[] x = s.toCharArray();
        for (int limit = 0; limit < s.length(); limit++) {
            boolean found = false;
            for (int i = 0; i < x.length - 1; i++) {
                int j = (i + 1) % (x.length);
                int k = (i + 2) % (x.length);
                char a = x[i];
                char b = x[j];
                char c = x[k];
                if (a == b && a != c) {
                    x[j] = c;
                    x[k] = b;
                    found = true;
                }
            }
            if (!found) {
                break;
            }
        }
        return new String(x);
    }

}
