package com.in.String05;

class Calculate {
	public int compress(char[] chars) {
		int n = chars.length;
		int index = 0; // Index to keep track of the current position in the modified array

		for (int i = 0; i < n; i++) {
			char currChar = chars[i];
			int count = 1; // Count of consecutive repeating characters

			// Count the number of consecutive repeating characters
			while (i + 1 < n && chars[i + 1] == currChar) {
				count++;
				i++;
			}

			// Store the current character in the modified array
			chars[index] = currChar;
			index++;

			// If the count is greater than 1, store the count as characters
			if (count > 1) {
				String countStr = String.valueOf(count);
				for (char c : countStr.toCharArray()) {
					chars[index] = c;
					index++;
				}
			}
		}

		return index;
	}
}

public class CountChar {

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		Calculate cal = new Calculate();
		int newLength = cal.compress(chars);
		System.out.println(newLength);

		// Print the modified array
		for (int i = 0; i < newLength; i++) {
			System.out.print(chars[i] + " ");
		}
	}

}
