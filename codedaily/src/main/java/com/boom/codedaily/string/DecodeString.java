package com.boom.codedaily.string;

import java.util.*;

public class DecodeString {
	public String decodeString(String s) {
		Deque<Integer> numStack = new LinkedList<>();
		int k = 0;
		StringBuilder sb = new StringBuilder();
		Deque<StringBuilder> stringStack = new LinkedList<>();
		stringStack.push(new StringBuilder());
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if ('[' == c) {
				numStack.push(k);
				stringStack.push(sb);
				sb = new StringBuilder();
				k = 0;
			} else if (']' == c) {
				String multipliedStr = multiplyString(sb.toString(), numStack.pop());
				sb = new StringBuilder(stringStack.pop());
				sb.append(multipliedStr);
			} else if (Character.isDigit(c)) {
				k = k * 10 + Character.getNumericValue(c);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String multiplyString(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		String s = "3[a]2[bc]";
		System.out.println(ds.decodeString("3[a2[c]]"));

	}

}
