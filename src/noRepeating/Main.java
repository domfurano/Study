package noRepeating;

import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	
	public String noRepeatingCharacters(String s) throws IllegalArgumentException {
		char[] chars = s.toCharArray();		
		Hashtable<Character, Integer> charFreq = new Hashtable<Character, Integer>();
		
		for (Character c : chars) {
			if (charFreq.putIfAbsent(c, 1) != null) {
				charFreq.put(c, charFreq.get(c) + 1);
			}
		}		
		
		Set<Character> keySet = charFreq.keySet();
		PriorityQueue<CharAndInt> maxHeap = new PriorityQueue<>();
		
		for (Character c : keySet) {
			maxHeap.add(new CharAndInt(c, charFreq.get(c)));
		}
		
		CharAndInt max = maxHeap.peek();
		if (max.i >= (s.length() / 2) + 1) {
			throw new IllegalArgumentException();
		}
		
		StringBuilder sb = new StringBuilder(s.length());		
		
		while (sb.length() < s.length()) {
			CharAndInt ci_1 = maxHeap.poll();
			CharAndInt ci_2 = maxHeap.poll();
			
			if (ci_2 == null) {
				sb.append(ci_1.c);
				break;
			}
			
			sb.append(ci_1.c);
			sb.append(ci_2.c);
			
			ci_1.i--;
			ci_2.i--;
			
			if (ci_1.i > 0) {
				maxHeap.add(ci_1);
			}
			if (ci_2.i > 0) {
				maxHeap.add(ci_2);
			}			
		}		

		return sb.toString();
		
	}
	
	protected static class CharAndInt implements Comparable<CharAndInt> {
		public final Character c;
		public Integer i;
		
		public CharAndInt(Character c, Integer i) {
			this.c = c;
			this.i = i;
		}
		
		@Override
		public int compareTo(CharAndInt o) {
			if (o == null) {
				throw new NullPointerException();
			}			
			return o.i.compareTo(this.i);
		}
	}

}
