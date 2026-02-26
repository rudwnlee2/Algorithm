import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int k;

	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n * 2];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		while(true) {
			count++;

			int temp = arr[arr.length - 1];
			for(int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;

			for(int i = visited.length - 1; i > 0; i--) {
				visited[i] = visited[i - 1];
			}
			visited[0] = false;

			if(visited[visited.length - 1]) {
				visited[visited.length - 1] = false;
			}

			for (int i = n - 2; i >= 0; i--) {
				if(visited[i] && !visited[i + 1] && arr[i + 1] > 0) {
					visited[i] = false;
					visited[i + 1] = true;
					arr[i + 1]--;
				}
			}

			if(visited[n - 1]) visited[n - 1] = false;

			if(arr[0] > 0) {
				visited[0] = true;
				arr[0]--;
			}
			
			if(stopCheck()) break;
		}
		
		System.out.println(count);
	}

	private static boolean stopCheck() {
		int zeroCount = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) zeroCount++;
		}
	
		if(zeroCount >= k) {
			return true;
		}

		return false;
	}
	
}