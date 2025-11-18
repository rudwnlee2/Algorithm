import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{
		for(int ts = 1; ts <= 10; ts++) {
			int result = solution();
			System.out.println("#" + ts + " " + result);
		}
	}
	
	private static int solution() throws Exception {
        br.readLine();
        
		int[][] arr = new int[100][100];
		StringTokenizer st;
		
		for(int i = 0; i < 100; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 100; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i = 0; i < 100; i++) {
			int sumX = 0;
			int sumY = 0;
			
			for(int j = 0; j < 100; j++) {
				sumX += arr[i][j];
				sumY += arr[j][i];
			}
			max = Math.max(max, sumX);
			max = Math.max(max, sumY);
		}
		
		int temp = 0;
		for(int i = 0; i < 100; i++) {
			temp += arr[i][i];
		}
		max = Math.max(max, temp);
		
		temp = 0;
		for(int i = 0; i < 100; i++) {
			temp += arr[i][99 - i];
		}
        max = Math.max(max, temp);
		
		return max;
	}

}
