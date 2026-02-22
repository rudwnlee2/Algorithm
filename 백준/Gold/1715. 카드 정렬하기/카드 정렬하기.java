import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		while(pq.size() > 1) {
			int temp = pq.poll();
			temp += pq.poll();
			
			sum += temp;
			pq.offer(temp);
		}

		System.out.println(sum);
	}
}