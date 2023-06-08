package com.in.String04;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

class Evaluate {
	public TreeNode str2tree(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		// Find the index of the first '('
		int leftParenIndex = s.indexOf('(');

		// If '(' is not found, then the entire string represents the root value
		if (leftParenIndex == -1) {
			return new TreeNode(Integer.parseInt(s));
		}

		// Create the root node with the root value
		TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, leftParenIndex)));

		// Find the index of the matching ')' for the first '('
		int matchingParenIndex = findMatchingParenIndex(s, leftParenIndex);

		// Construct the left child node recursively
		root.left = str2tree(s.substring(leftParenIndex + 1, matchingParenIndex));

		// If there are more characters after the first ')', construct the right child
		// node recursively
		if (matchingParenIndex < s.length() - 1) {
			root.right = str2tree(s.substring(matchingParenIndex + 2, s.length() - 1));
		}

		return root;
	}

	private int findMatchingParenIndex(String s, int start) {
		int count = 0;
		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
				if (count == 0) {
					return i;
				}
			}
		}
		return -1; // Invalid input, matching ')' not found
	}
}

public class Tree {

	public static void main(String[] args) {
		String input = "4(2(3)(1))(6(5))";
		Evaluate solution = new Evaluate();
		TreeNode root = solution.str2tree(input);
	}

}
