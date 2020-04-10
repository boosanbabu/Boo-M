package com.boom.codedaily.string;

import java.util.*;

public class BackSpaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		return backspaceCompareNoExtraSpace(S, T);
	}

	public boolean backspaceCompareNoExtraSpace(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		while (i >= 0 || j >= 0) {
			i = moveCursorOnBackspace(S, i);
			j = moveCursorOnBackspace(T, j);
			if (i >= 0 && j >= 0) {
				if (S.charAt(i--) != T.charAt(j--))
					return false;
			}
		}
		return true;
	}

	private int moveCursorOnBackspace(String str, int ptr) {
		int asterikCount = 0;
		while (ptr >= 0) {
			if (str.charAt(ptr) == '#') {
				ptr--;
				asterikCount++;
			} else if (asterikCount > 0) {
				asterikCount--;
				ptr--;
			} else {
				break;
			}
		}
		return ptr;
	}

	public boolean backspaceCompareUsingStack(String S, String T) {
		Deque<Character> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();
		computeEffectiveString(S, s1);
		computeEffectiveString(T, s2);
		if (s1.size() != s2.size())
			return false;
		while (!s1.isEmpty()) {
			if (s1.pop() != s2.pop())
				return false;
		}
		return true;
	}

	private void computeEffectiveString(String str, Deque<Character> stack) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '#') {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(str.charAt(i));
			}
		}
	}

	public static void main(String[] args) {
		BackSpaceStringCompare bsl = new BackSpaceStringCompare();
		//
		System.out.println(bsl.backspaceCompare("bxj##tw", "bxo#j##tw"));
	}

}
