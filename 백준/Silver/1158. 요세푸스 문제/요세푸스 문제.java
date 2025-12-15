import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}

		System.out.print("<");
		while(q.size() != 1) {
			for(int i = 0; i < k - 1; i++) {
				q.offer(q.poll());
			}
			System.out.print(q.poll() + ", ");
		}

		System.out.print(q.poll() + ">");
	}
}