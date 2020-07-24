package dsa.leetcode.medium.thread;

import java.util.LinkedList;
import java.util.*;

public class ProducerConsumerEvenOdd {
	public static void main(String[] args) throws InterruptedException {

		final ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// Create consumer thread
		Thread t2 = new Thread(() -> {
			try {
				pc.consume();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

// Start both threads
		t1.start();
		t2.start();

// t1 finishes before t2
		t1.join();
		t2.join();
	}

// This class has a list, producer (adds items to list
// and consumber (removes items).
	public static class ProducerConsumer {

		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 100;

		public void produce() throws InterruptedException {

			int value = 0;
			while (true) {
				synchronized (this) {
					value = scanner.nextInt();
					while (list.size() == capacity)
						wait();
					list.add(value);
					notify();
					Thread.sleep(1000);
				}
			}
		}

		// Function called by consumer thread
		public void consume() throws Exception {
			while (true) {
				synchronized (this) {
					while (list.size() == 0)
						wait();
					int val = list.removeFirst();
					if (val % 2 == 1) {
						System.out.println("Odd" + val);
					} else
						System.out.println("Even" + val);
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}