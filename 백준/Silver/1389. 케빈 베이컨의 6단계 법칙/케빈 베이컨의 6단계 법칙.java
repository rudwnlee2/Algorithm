import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
			map.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
		}

		int min = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		
		for(int num : map.keySet()) {
			int count = 0;

			Queue<int[]> q = new LinkedList<>();
			Set<Integer> visited = new HashSet<>();

			q.offer(new int[] {num, 0});
			visited.add(num);

			while(!q.isEmpty()) {
				int[] temp = q.poll();

				count += temp[1];

				ArrayList<Integer> arrTemp = map.get(temp[0]);
				for(int i : arrTemp) {
					if(visited.contains(i)) continue;
					visited.add(i);
					q.offer(new int[] {i, temp[1] + 1});
				}
			}

			if(count < min) {
				min = count;
				result = num;
			} else if(count == min) {
				result = Math.min(result, num);
			}
		}
		
		System.out.println(result);
	}
}