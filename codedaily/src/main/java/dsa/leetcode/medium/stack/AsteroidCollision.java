package dsa.leetcode.medium.stack;

import java.util.*;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Deque<Integer> stack = new LinkedList<>();
		for (int a : asteroids) {
			if (collisionNotPossible(stack, a)) {
				stack.push(a);
			} else {
				while (!stack.isEmpty() && a < 0 && stack.peek() > 0 && stack.peek() < -a)
					stack.pop();
				if (!stack.isEmpty() && -a == stack.peek())
					stack.pop();
				else if (collisionNotPossible(stack, a))
					stack.push(a);
			}
		}

		int res[] = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty())
			res[i++] = stack.removeLast();
		return res;
	}

	private boolean collisionNotPossible(Deque<Integer> stack, Integer a) {
		if (stack.isEmpty() || a > 0)
			return true;
		if (a < 0 && stack.peek() < 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		AsteroidCollision a = new AsteroidCollision();
		int[] res = a.asteroidCollision(new int[] { 5, 10, -5 });
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();

		res = a.asteroidCollision(new int[] { -2, -2, 1, -2 });
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();

		res = a.asteroidCollision(new int[] { 8, -8 });
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();

		res = a.asteroidCollision(new int[] { 8, 8, 8 });
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
