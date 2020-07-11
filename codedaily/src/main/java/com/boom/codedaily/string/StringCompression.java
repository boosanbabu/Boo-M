package com.boom.codedaily.string;

public class StringCompression {
	/*
	 * Input/Output examples
	 * 
	 * aaabbcc -> a3b2c2 (return 6)
	 * 
	 * abc -> abc (return 3)
	 * 
	 * abcc -> abc2 (return 4)
	 * 
	 * aabbbbbbbbbbbbb -> a2b13 (return 5)
	 * 
	 */
	public int compress(char[] chars) {
		int readPtr = 1, w = 0, start = 0, len = chars.length;
		while (readPtr < len) {
			if (chars[w] == chars[readPtr]) {
				readPtr++;
			} else {
				if (readPtr - start > 1) {
					w = fillNumber(chars, w, readPtr - start);
				}
				chars[++w] = chars[readPtr];
				start = readPtr;
			}
		}
		if (readPtr - start > 1) {
			w = fillNumber(chars, w, readPtr - start);
		}
		return w + 1;
	}

	// If count of any character is greater than 10 -> eg., 18 -> ['1','8']
	public int fillNumber(char[] arr, int i, int num) {
		for (char c : ("" + num).toCharArray()) {
			arr[++i] = c;
		}
		return i;
	}

	public static void main(String[] args) {
		String inp = "aaabbcdde";
		StringCompression s = new StringCompression();
		s.compress(inp.toCharArray());
	}

}
