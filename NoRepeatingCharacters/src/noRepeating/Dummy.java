package noRepeating;

import java.util.LinkedList;
import java.util.ArrayList;

// This is the actual code I wrote for the interview.
public class Dummy {

	public String noRepeatingChars(String s) {
		// if string empty
		if (s.isEmpty() || s.length() == 1) {
			return s;
		}

		LinkedList<String> oldString = new LinkedList<>();

		String os[] = s.split("");
		for (int i = 0; i < s.length(); i++) {
			oldString.add(os[i]);
		}

		ArrayList<String> newString = new ArrayList<>();

		int oldStringLength;

		do {
			oldStringLength = oldString.size();
			for (int i = 0; i < oldString.size(); i++) {
				if (newString.size() == 0) {
					newString.add(oldString.get(i));
					oldString.remove(i);
					continue;
				}
				if (newString.get(newString.size() - 1).compareTo(oldString.get(i)) == 0) {
					continue;
				} else {
					newString.add(oldString.get(i));
					oldString.remove(i);
				}
			}
		} while (oldStringLength != oldString.size());

		if (oldStringLength == 0) {
			// Turn oldString into string and return
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < newString.size(); i++) {
				sb.append(newString.get(i));
			}
			return sb.toString();
		} else {
			return null;
		}
	}


}
