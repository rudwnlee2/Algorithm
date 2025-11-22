import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int ts = 1; ts <= 10; ts++) {
			int t = Integer.parseInt(br.readLine());
			int startY = 0;
			int startX = 0;
			
			int[][] arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {
						startY = i;
						startX = j;
					}
				}
			}
			
			int result = 0;
			int dir = 0;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {startY, startX, dir});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int y = temp[0];
				int x = temp[1];
				dir = temp[2];
				
				if(y == 0) {
					result = x;
					break;
				}
				
				if (x - 1 >= 0 && arr[y][x - 1] == 1 && dir != 2) {
					q.offer(new int[] {y, x - 1, 1});
				} else if (x + 1 < 100 && arr[y][x + 1] == 1 && dir != 1) {
					q.offer(new int[] {y, x + 1, 2});
				} else {
					q.offer(new int[] {y - 1, x, 3});
				}
				
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}