import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[] result = new int[n];
		int[][] arr = new int[n][2];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < n; i++) {
			int temp = 1;
			for(int j = 0; j < n; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					temp++;
				}
			}
			result[i] = temp;
		}

		
		for(int i : result) {
			System.out.print(i + " ");
		}
		
	}
}