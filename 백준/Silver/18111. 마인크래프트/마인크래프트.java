import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max < arr[i][j]) {
					max = arr[i][j];
				} else if(min > arr[i][j]) {
					min = arr[i][j];
				}
			}
		}

		int minT = Integer.MAX_VALUE;
		int h = min;
		for(int i = min; i <= max; i++) {
			int countTime = 0;
			int block = b;

			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(arr[j][k] < i) {
						block -= i - arr[j][k];
						countTime += i - arr[j][k];
					} else if(arr[j][k] > i) {
						countTime += (arr[j][k] - i) * 2;
						block += arr[j][k] - i;
					}
				}
				
			}

			if(block < 0) continue;
			
			if(minT > countTime) {
				h = i;
				minT = countTime;
			} else if(minT == countTime && i > h) {
				h = i;
			}
			
		}
		
		System.out.println(minT + " " + h);
	}
}