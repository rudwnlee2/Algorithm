import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];


		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] inc = new int[n + 1];
		for (int i = 0; i < n; i++) {
			inc[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					inc[i] = Math.max(inc[i], inc[j] + 1);
				}
			}
		}
		
		int[] dec = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			dec[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[i]) {
					dec[i] = Math.max(dec[i], dec[j] + 1);
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, inc[i] + dec[i] - 1);
		}
		System.out.println(result);
	}
}