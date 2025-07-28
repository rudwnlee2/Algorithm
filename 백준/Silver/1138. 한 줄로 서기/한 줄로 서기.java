import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= n; i++) {
			int count = arr[i - 1];
			for(int j = 0; j < n; j++) {
				if(result[j] == 0) {
					if(count == 0) {
						result[j] = i;
						break;
					}
					count--;
				} 
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
		
	}

}