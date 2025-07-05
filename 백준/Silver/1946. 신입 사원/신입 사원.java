import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n;
		int count;
		int[] result = new int[t];
		
		for(int i = 0; i < t; i++) {
			
			n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2];
			
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, (o1, o2) -> {
				return o1[0] - o2[0];
			});

			count = 1;
			int temp = arr[0][1];
			for(int j = 1; j < n; j++) {
				if(temp > arr[j][1]) {
					count++;
					temp = arr[j][1];
				}
			}
			result[i] = count;
		}

		for(Integer i : result) {
			System.out.println(i);
		}
		
	}
}