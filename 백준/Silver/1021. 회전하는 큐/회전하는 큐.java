import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Integer> deque = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			deque.offer(i);
		}

		int count = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());

			int index = deque.indexOf(num);
			int half = deque.size() / 2;

			if(index <= half) {
				while(deque.getFirst() != num) {
					deque.offerLast(deque.pollFirst());
					count++;
				}
			} else {
				while(deque.getFirst() != num) {
					deque.addFirst(deque.pollLast());
					count++;
				}
			}

			deque.pollFirst();
		}

		System.out.println(count);
	}
}