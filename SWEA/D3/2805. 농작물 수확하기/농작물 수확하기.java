import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				String temp = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = temp.charAt(j) - '0';
				}
			}
			
			int count = 0;
			int start = n / 2;
			int end = n / 2;
			for(int i = 0; i < n / 2 + 1; i++) {
				for(int j = start; j <= end; j++) {
					count += arr[i][j];
					if (i != n / 2) {
						count += arr[n - 1 - i][j];
					}
				}
				start--;
				end++;
			}
			
			System.out.println("#" + test_case + " " + count);
		}
		
	}
}