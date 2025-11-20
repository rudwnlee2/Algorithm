import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int ts = 1; ts<= 10; ts++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for(int i = 2; i < n - 2; i++) {
				int leftMax = Math.max(arr[i - 1], arr[i - 2]);
				int rightMax = Math.max(arr[i + 1], arr[i + 2]);
				
				int max = Math.max(leftMax, rightMax);
				
				if(arr[i] > max) {
					count += arr[i] - max;
				}
			}
			
			System.out.println("#" + ts + " " + count);
		}
	}
}