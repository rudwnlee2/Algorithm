import java.io.*;
import java.util.*;

class Main {

	static int[] arr;
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];

		dfs(0, 1);
	}

	static void dfs(int count, int start) {
		if(count == m) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for(int i = start; i <= n; i++) {
				arr[count] = i;
				dfs(count + 1, i);
		}
	}
}