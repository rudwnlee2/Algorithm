import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		long[] result = new long[t];

		int n;
		long[] arr;
		StringTokenizer st;
		long benefit;
		long temp;
		
		for(int i = 0; i < t; i++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new long[n];
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			temp = arr[n-1];
			benefit = 0;
			for(int j = n - 2; j >= 0; j--) {
				if(temp > arr[j]) {
					benefit += temp - arr[j];
				} else {
					temp = arr[j];
				}
			}

			result[i] = benefit;
			
		}

		for(int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		
	}
}