import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[19][19];
	
		int[] dy = {0, 1, 1, -1};
		int[] dx = {1, 0, 1, 1};

		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if (arr[i][j] != 0) {
					int color = arr[i][j];

					for(int dir = 0; dir < 4; dir++) {
						int count = 1;
						int ny = i;
						int nx = j;

						while(true) {
							ny += dy[dir];
							nx += dx[dir];

							if(ny < 0 || nx < 0 || ny >= 19 || nx >= 19 || arr[ny][nx] != color) break;

							count++;
						}

						if(count == 5) {
							if(i - dy[dir] >= 0 && j - dx[dir] >= 0 && i - dy[dir] < 19 && j - dx[dir] < 19 && arr[i - dy[dir]][j - dx[dir]] == color) continue;
							
							System.out.println(color);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
						
					}
					
				}
					
			}
		}
		
		System.out.println(0);
	}
	
}