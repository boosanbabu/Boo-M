package dsa.leetcode.medium.array;

/*
 * 1529. Bulb Switcher IV
 * https://leetcode.com/problems/bulb-switcher-iv/
 * 
There is a room with n bulbs, numbered from 0 to n-1, arranged in a row from left to right. Initially all the bulbs are turned off.

Your task is to obtain the configuration represented by target where target[i] is '1' if the i-th bulb is turned on and is '0' if it is turned off.

You have a switch to flip the state of the bulb, a flip operation is defined as follows:

Choose any bulb (index i) of your current configuration.
Flip each bulb from index i to n-1.
When any bulb is flipped it means that if it is 0 it changes to 1 and if it is 1 it changes to 0.

Return the minimum number of flips required to form target.


Input: target = "10111"
Output: 3
Explanation: Initial configuration "00000".
flip from the third bulb:  "00000" -> "00111"
flip from the first bulb:  "00111" -> "11000"
flip from the second bulb:  "11000" -> "10111"
We need at least 3 flip operations to form target.

 
 */
public class BulbSwitcherIV {
	/*
	 * https://leetcode.com/problems/bulb-switcher-iv/discuss/756591/JAVA-Detailed-
	 * Explanation-with-Picture
	 * 
	 * Idea is to flip at the points where there is a change in state (0->1 or
	 * 1->0). Iterate from the beginning do nothing until the state is same, when
	 * you encounter a change in state add flip count at that point. Say when you
	 * are iterating for the target 00110100 - for the first two zeroes do nothing,
	 * when you encounter 0->1 add flip count, again for the two consecutive 1's do
	 * nothing when you encounter 1->0 add flip count again.
	 */
	public int minFlips(String target) {
		int res = 0;
		char prev = '0';
		for (int i = 0; i < target.length(); i++) {
			char curr = target.charAt(i);
			if (prev != curr) {
				res++;
				prev = curr;
			}
		}
		return res;
	}

	public static void main(String aa[]) {
		BulbSwitcherIV b = new BulbSwitcherIV();
		System.out.println(b.minFlips("00001011110001"));
	}
}
