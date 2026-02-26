import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		if (n == 0) {
			System.out.println(1);
			return;
		}
		
		int[] arr= new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if(n == p && score <= arr[n - 1]) {
			System.out.println(-1);
			return;
		}
		
		int rank = 1;
		for(int i = 0; i < n; i++) {
			if(arr[i] > score) rank++;
		}

		System.out.println(rank);
	}
}