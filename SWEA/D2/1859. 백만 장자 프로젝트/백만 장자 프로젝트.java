import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long count = 0;
			int max = 0;
			for(int i = n - 1; i >= 0; i--) {
				if(max < arr[i]) {
					max = arr[i];
				} else {
					count += max - arr[i];
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}
}