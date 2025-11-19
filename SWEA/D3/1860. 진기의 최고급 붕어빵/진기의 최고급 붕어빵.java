import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws Exception {
		int t = Integer.parseInt(br.readLine());

		for(int ts = 1; ts <= t; ts++) {
			System.out.print("#" + ts + " ");
			soulution();
			System.out.println();
		}
	}
	
	private static void soulution() throws Exception {
		String result = "Possible";
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			int fish = (arr[i] / m * k) - i;
			
			if(fish < 1) {
				result = "Impossible";
				break;
			}
		}
		
		
		System.out.print(result);
	}
}