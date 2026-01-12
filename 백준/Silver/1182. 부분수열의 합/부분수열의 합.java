import java.io.*;
import java.util.*;

class Main {

	static int[] arr;
	static int count = 0;
	static int n;
	static int s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		if(s == 0) {
			System.out.println(count - 1);
		} else {
			System.out.println(count);
		}
		
	}

	private static void dfs(int depth, int sum) {
		if(depth == n) {
			if(sum == s) count++;
			return;
		}
		
		dfs(depth + 1, sum + arr[depth]);

		dfs(depth + 1, sum);
	}
}