import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		Deque<Integer> deque = new ArrayDeque<>(); 
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();

			if (temp.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.offerFirst(num);
			} else if (temp.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				deque.offerLast(num);
			} else if (temp.equals("pop_front")) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.pollFirst());
				}
			} else if (temp.equals("pop_back")) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.pollLast());
				}
			} else if (temp.equals("size")) {
				System.out.println(deque.size());
			} else if (temp.equals("empty")) {
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (temp.equals("front")) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekFirst());
				}
			} else if (temp.equals("back")) {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekLast());
				}
			}
		}

	}
}