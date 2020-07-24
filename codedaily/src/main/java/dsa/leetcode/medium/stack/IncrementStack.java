package dsa.leetcode.medium.stack;

public class IncrementStack {
	int[] stack;
	int top;

	public IncrementStack(int maxSize) {
		stack = new int[maxSize];
		top = -1;
	}

	public void push(int x) {
		if (top == stack.length - 1)
			return;
		stack[++top] = x;
	}

	public int pop() {
		if (top == -1)
			return -1;
		return stack[top--];
	}

	public void increment(int k, int val) {
		k = Math.min(k, stack.length);
		for (int i = 0; i < k; i++)
			stack[i] += val;
	}

	public static void main(String[] args) {
		IncrementStack i = new IncrementStack(3);
		i.push(1); // stack becomes [1]
		i.push(2); // stack becomes [1, 2]
		System.out.println(i.pop()); // return 2 --> Return top of the stack 2, stack becomes [1]
		i.push(2); // stack becomes [1, 2]
		i.push(3); // stack becomes [1, 2, 3]
		i.push(4); // stack still [1, 2, 3], Don't add another elements as size is 4
		i.increment(5, 100); // stack becomes [101, 102, 103]
		i.increment(2, 100); // stack becomes [201, 202, 103]
		System.out.println(i.pop()); // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		System.out.println(i.pop()); // return 202 --> Return top of the stack 102, stack becomes [201]
		System.out.println(i.pop()); // return 201 --> Return top of the stack 101, stack becomes []
		System.out.println(i.pop()); // return -1 --> Stack is empty return -1.
	}

}
