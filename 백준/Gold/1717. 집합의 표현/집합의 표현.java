import java.io.*;
import java.util.*;

class Main {
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(num == 0) {
				union(a, b);
			} else {
				int x = find(a);
				int y = find(b);
				if(x == y) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
			
		}
		
		// 메모리 초과
		// for(int i = 0; i < m; i++) {
		// 	st = new StringTokenizer(br.readLine());
		// 	int num = Integer.parseInt(st.nextToken());

		// 	if(num == 0) {
		// 		int a = Integer.parseInt(st.nextToken());
		// 		int b = Integer.parseInt(st.nextToken());

		// 		arr[b].add(a);
		// 		arr[a].add(b);
		// 	} else {
		// 		int a = Integer.parseInt(st.nextToken());
		// 		int b = Integer.parseInt(st.nextToken());

		// 		if (a == b) {
		//       sb.append("YES\n");
		//       continue;
		//     }

		// 		visited = new boolean[n + 1];
		// 		visited[a] = true;
		// 		check = false;
		// 		find(a, b);

		// 		if(check) {
		// 			sb.append("YES\n");
		// 		} else {
		// 			sb.append("NO\n");
		// 		}
		// 	}
		// }

		// 메모리 초과
		// for(int i = 0; i < m; i++) {
		// 	st = new StringTokenizer(br.readLine());
		// 	int num = Integer.parseInt(st.nextToken());

		// 	if(num == 0) {
		// 		int a = Integer.parseInt(st.nextToken());
		// 		int b = Integer.parseInt(st.nextToken());

		// 		boolean[] visited = new boolean[n + 1];

		// 		visited[a] = true;
		// 		for(int x : arr[a]) {
		// 			arr[b].add(x);
		// 		}

		// 		visited[a] = true;
		// 		for(int x : arr[b]) {
		// 			arr[a].add(x);
		// 		}

		// 		for(int x : arr[a]) {
		// 			if(visited[x]) continue;
		// 			visited[x] = true;
		// 			for(int y : arr[a]) {
		// 				arr[x].add(y);
		// 			}
		// 		}
		// 	} else {
		// 		int a = Integer.parseInt(st.nextToken());
		// 		int b = Integer.parseInt(st.nextToken());

		// 		boolean check = false;
		// 		for(int x : arr[a]) {
		// 			if(x == b) {
		// 				sb.append("YES\n");
		// 				check = true;
		// 				break;
		// 			}
		// 		}
		// 		if(!check) {
		// 			sb.append("NO\n");
		// 		}
		// 	}
		// }
		
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);

		if(x != y) {
			arr[y] = x;
		}
	}

	private static int find(int num) {
		if(arr[num] == num) {
			return num;
		}

		return find(arr[num]);
	}

	// private static void find(int index, int num) {
		
	// 	for(int i : arr[index]) {
	// 		if(visited[i]) continue;

	// 		if(i == num) {
	// 			check = true;
	// 			return;
	// 		} else {
	// 			visited[i] = true;
	// 			find(i, num);
	// 		}
	// 	}
		
	// }
	
}