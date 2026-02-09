import java.io.*;
import java.util.*;

class Main {

	static int l;
	static int c;

	static char[] arr;
	static boolean[] visited;
	static char[] result;

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[c];
		visited = new boolean[c];
		result = new char[l];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			String temp = st.nextToken();
			arr[i] = temp.charAt(0);
		}

		Arrays.sort(arr);
		for(int i = 0; i < c - 1; i++) {
			visited[i] = true;
			result[0] = arr[i];
			dfs(1);
			visited[i] = false;
		}
		
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == l) {
			boolean resultCheck = false;
			int resultCheckNum = 0;
			
			for(int i = 0; i < l; i++) {
				if(check(result[i])) {
					resultCheck = true;
				} else {
					resultCheckNum++;
				}
			}

			if(resultCheck && resultCheckNum >= 2) {
				for(int i = 0; i < l; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			
			return;
		}

		for(int i = 0; i < c; i++) {
			if(!visited[i]) {
				if(result[depth - 1] < arr[i]) {
					result[depth] = arr[i];
					visited[i] = true;
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
		
	}

	private static boolean check(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
}