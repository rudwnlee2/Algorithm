import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        if (absA == absB) return a - b;
        return absA - absB;
    });
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.offer(num);
			}
		}

		System.out.println(sb);
	}
}