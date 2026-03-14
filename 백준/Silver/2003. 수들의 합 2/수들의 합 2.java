import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		for(int i = 0 ; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += arr[j];
				if(sum == m) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}