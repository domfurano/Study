package noRepeating;

import org.junit.Assert;

import static org.junit.Assert.*;

import java.io.PrintWriter;

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
    
    @org.junit.Test
    public void timingTest() throws Exception {    	
    	NoRepeats noRepeats = new NoRepeats();
    	Main main = new Main();
    	Dummy dummy = new Dummy();
    	
    	PrintWriter writer = new PrintWriter("result.csv");
    	writer.write("N,logN,NlogN,N^2,nieve,dom_interview,better\n");
    	
    	for (int N = 1000; N < 10000; N += 1000) {
	    	int N_2 = N / 2;
	    	StringBuilder sb = new StringBuilder(N);
	    	
	    	for (int i = 0; i < N; i++) {
	    		if (i < N_2) {
	    			sb.append("A");
	    		} else {
	    			sb.append("B");
	    		}
	    	}
	    	
	    	String bigString = sb.toString();
	    	
	    	long time_1_start = System.nanoTime();
	    	noRepeats.noRepeatingCharacters(bigString);
	    	long time_1_end = System.nanoTime();
	    	
	    	long time_2_start = System.nanoTime();
	    	main.noRepeatingCharacters(bigString);
	    	long time_2_end = System.nanoTime();
	    	
	    	long time_3_start = System.nanoTime();
	    	dummy.noRepeatingChars(bigString);
	    	long time_3_end = System.nanoTime();
	    	
	    	String[] line = { Integer.toString(N), Double.toString(Math.log(N)),
	    			Double.toString(N * Math.log(N)), Integer.toString(N * N),
	    			Long.toString(time_1_end - time_1_start),
	    			Long.toString(time_3_end - time_3_start),
	    			Long.toString(time_2_end - time_2_start) };
	    	writer.write(String.join(",", line) + "\n");
    	}
    	writer.close();
    }
}















