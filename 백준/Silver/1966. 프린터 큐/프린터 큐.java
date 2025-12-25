import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int ts = 0; ts < t; ts++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			List<Integer> list = new ArrayList<>();
			Queue<int[]> q = new LinkedList<>();
			int num = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				if (i == m) num = i;
				int temp = Integer.parseInt(st.nextToken());
				q.offer(new int[] {temp, i});
				list.add(temp);
			}

			Collections.sort(list, Collections.reverseOrder());
			int result = 0;
			while (!q.isEmpty()) {
				int[] temp = q.peek();
				if(list.get(0) == temp[0]) {
					result++;
					if(temp[1] == m) break;
					q.poll();
					list.remove(0);
				} else {
					q.offer(q.poll());
				}
			}

			System.out.println(result);
		}
		
	}
}