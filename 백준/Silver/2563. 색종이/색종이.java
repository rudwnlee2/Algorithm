import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		boolean[][] arr = new boolean[101][101];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());

			for(int y = tempY; y < tempY + 10; y++) {
				for(int x = tempX; x < tempX + 10; x++) {
					if(!arr[y][x]) {
						arr[y][x] = true;
					}
				}
			}
		}

		int result = 0;
		for(boolean[] i : arr) {
			for(boolean j : i) {
				if(j) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}