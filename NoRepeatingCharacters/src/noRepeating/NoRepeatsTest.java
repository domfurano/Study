package noRepeating;

import org.junit.Assert;

import static org.junit.Assert.*;


/**
 * Created by calvin on 3/5/16.
 */
public class NoRepeatsTest {

    @org.junit.Test
    public void testNoRepeatingCharacters() throws Exception {
        String[] strings = new String[] {
                "bbbaa",
                "aaabc",
                "banana",
                "aardvark",
                "cccaaalllvvv",
                "dddooommm"
        };

        for (String string : strings) {
            NoRepeats noRepeats = new NoRepeats();
            String s = noRepeats.noRepeatingCharacters(string);
            System.out.println(s);
            validateString(s);
        }
    }

    private void validateString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            assertNotEquals(s.substring(i, i + 1), s.substring(i + 1, i + 2));
        }
    }

}















