import java.io.*;
import java.util.*;

class Main {
	static int[] arr;
	static int n;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		dfs(0);
		System.out.println(count);
	}

	private static void dfs(int depth) {
		if(depth == n) {
			count++;
			return;
		}

		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			if(check(depth)) {
				dfs(depth + 1);
			}
		}
	}

	private static boolean check(int depth) {
		for(int i = 0; i < depth; i++) {
			if(arr[depth] == arr[i]) {
				return false;
			} else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}

		return true;
	}
}