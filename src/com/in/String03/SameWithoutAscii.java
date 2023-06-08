package com.in.String03;

public class SameWithoutAscii {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		// Create a 2D array to store the minimum number of steps
		int[][] dp = new int[m + 1][n + 1];

		// Fill the first row
		for (int j = 1; j <= n; j++) {
			dp[0][j] = dp[0][j - 1] + 1;
		}

		// Fill the first column
		for (int i = 1; i <= m; i++) {
			dp[i][0] = dp[i - 1][0] + 1;
		}

		// Fill the rest of the array
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// If the characters are equal, no deletion is needed
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// Delete the character with minimum steps
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {

	}

}
