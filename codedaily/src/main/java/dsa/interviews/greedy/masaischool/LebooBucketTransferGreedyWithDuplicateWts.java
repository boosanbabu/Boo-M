package dsa.interviews.greedy.masaischool;

import java.util.*;
import java.io.*;

/**
 * You have got n buckets and m people. <br>
 * bucketWeights[i] denotes weight of bucket. <br>
 * maxCapPerPerson[i] maximum wt. a person could carry.
 * 
 * All buckets have to be carried from a place to other end, to place it at
 * other end it takes 1 hour and return back 1 hour, <br>
 * One person can carry only bucket of water at a time to the other end<br>
 * Of course, the person can return back and carry again minimize the amount of
 * time it will take to transfer all the buckets to other end. <br>
 * Find the minimum time it will take to transfer.
 * 
 * @author boosanbabu
 *
 */
public class LebooBucketTransferGreedyWithDuplicateWts {
	public static class Node {
		public Node(int i, int w) {
			wt = w;
			id = i;
		}

		public Node(int w) {
			wt = w;
			id = Integer.MAX_VALUE;
		}

		int wt;
		int id;

		public String toString() {
			return String.valueOf(wt);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (!(obj instanceof Node))
				return false;
			if (obj == this)
				return true;
			return this.wt == ((Node) obj).wt;
		}

		@Override
		public int hashCode() {
			return Objects.hash(wt, id);
		}
	}

	public static int minTimeToTransferLebooBuckets(int n, int m, int[] bucketWeights, int[] maxCapPerPerson) {
		int result = 0;
		TreeSet<Node> wts = new TreeSet<>((a, b) -> a.wt == b.wt ? a.id - b.id : a.wt - b.wt);
		PriorityQueue<Integer> peopleQ = new PriorityQueue<>();
		// Sort both the array, convert them to comfortable sorted- data structure.
		for (int i = 0; i < bucketWeights.length; i++)
			wts.add(new Node(i, bucketWeights[i]));
		for (int i = 0; i < maxCapPerPerson.length; i++)
			peopleQ.add(maxCapPerPerson[i]);

		int i = 1;
		while (!wts.isEmpty()) {
			for (Iterator<Integer> peopleItr = peopleQ.iterator(); peopleItr.hasNext();) {
				Integer personCapacity = peopleItr.next();
				Node w = wts.floor(new Node(personCapacity));
				if (w == null) {
					peopleItr.remove();
					continue;
				} else {
					wts.remove(w);
				}
			}

			result++;
			if (!wts.isEmpty()) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
			String[] ip1 = r.readLine().trim().split(" +");
			int n = Integer.parseInt(ip1[0]), m = Integer.parseInt(ip1[1]);

			String[] bws = r.readLine().trim().split(" +");
			int[] bucketWeights = new int[bws.length];
			for (int i = 0; i < bws.length; i++) {
				bucketWeights[i] = Integer.parseInt(bws[i]);
			}

			String[] caps = r.readLine().split(" +");
			int[] personCapacities = new int[caps.length];
			for (int i = 0; i < caps.length; i++) {
				personCapacities[i] = Integer.parseInt(caps[i]);
			}

			int result = minTimeToTransferLebooBuckets(n, m, bucketWeights, personCapacities);
			System.out.println(result);

		} catch (IOException e) {
			System.out.println("Error");
		}
	}

//    public static void main(String[] args) {

//	int[] bucketWeights = { 6, 79, 203, 212, 221, 275, 279, 343, 358, 372, 482, 502, 504, 594, 632, 642, 674, 679,
//			799, 823, 882 };
//	int[] maxCapPerPerson = { 29, 56, 87, 114, 120, 120, 480, 979 };//Expected answer is 21
//		int res = minTimeToTransferLebooBuckets(bucketWeights.length, maxCapPerPerson.length, bucketWeights,
//				maxCapPerPerson);
//		System.out.println(res);
//	}

}