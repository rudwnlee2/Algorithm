import java.io.*;
import java.util.*;

class Main {

	static char[][] white = {{'W','B','W','B','W','B','W','B'},
													 {'B','W','B','W','B','W','B','W'}};
	
	static char[][] black = {{'B','W','B','W','B','W','B','W'},
													 {'W','B','W','B','W','B','W','B'}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		int answer = 64;
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {

				int whiteCnt = 0;
				int blackCnt = 0;
				int y = 0;

				for(int k = i; k < i + 8; k++) {
					int x = 0;
					for(int l = j; l < j + 8; l++) {
						if(arr[k].charAt(l) != black[y][x]) {
							blackCnt++;
						}

						if(arr[k].charAt(l) != white[y][x]) {
							whiteCnt++;
						}
						x++;
					}
					y = (y + 1) % 2;
				}
				
				answer = Math.min(answer, Math.min(blackCnt, whiteCnt));
			}
		}

		System.out.println(answer);
	}
}