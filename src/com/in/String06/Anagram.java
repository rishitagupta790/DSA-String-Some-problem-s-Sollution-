package com.in.String06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();

		if (s.length() < p.length()) {
			return result;
		}

		int[] pCount = new int[26]; // Frequency count of characters in p
		int[] windowCount = new int[26]; // Frequency count of characters in the sliding window

		// Initialize the frequency count of characters in p
		for (char c : p.toCharArray()) {
			pCount[c - 'a']++;
		}

		int windowSize = p.length();

		// Initialize the frequency count of characters in the first window
		for (int i = 0; i < windowSize; i++) {
			windowCount[s.charAt(i) - 'a']++;
		}

		// Check each window for anagram
		for (int i = windowSize; i <= s.length(); i++) {
			// Compare the frequency counts of characters in the window and p
			if (Arrays.equals(windowCount, pCount)) {
				result.add(i - windowSize);
			}

			// Slide the window by removing the leftmost character and adding the rightmost
			// character
			if (i < s.length()) {
				windowCount[s.charAt(i) - 'a']++;
				windowCount[s.charAt(i - windowSize) - 'a']--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> result = findAnagrams(s, p);
		System.out.println(result);

	}

}
