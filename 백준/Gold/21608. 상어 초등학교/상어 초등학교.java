import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		int[][] list = new int[n * n][5];

		for(int i = 0; i < n * n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};

		for(int i = 0; i < list.length; i++) {
			int student = list[i][0];
			
			int maxLike = -1;
			int maxEmpty = -1;
			int bestY = -1;
			int bestX = -1;

			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					
					if(arr[y][x] != 0) continue; 
					
					int likeCnt = 0;
					int emptyCnt = 0;
					
					for(int j = 0; j < 4; j++) {
						int ny = y + dy[j];
						int nx = x + dx[j];

						if(ny >= n || nx >= n || ny < 0 || nx < 0) continue;

						if(arr[ny][nx] == 0) {
							emptyCnt++;
						} else {
							for(int l = 1; l < 5; l++) {
								if(arr[ny][nx] == list[i][l]) {
									likeCnt++;
									break;
								}
							}
						}
					}
					
					if (likeCnt > maxLike) {
						maxLike = likeCnt;
						maxEmpty = emptyCnt;
						bestY = y;
						bestX = x;
					} else if (likeCnt == maxLike && emptyCnt > maxEmpty) {
						maxLike = likeCnt;
						maxEmpty = emptyCnt;
						bestY = y;
						bestX = x;
					}
				}
			}

			arr[bestY][bestX] = student;
		}

		int score = 0;
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				int student = arr[y][x];
				int studentIdx = 0;

				for(int i = 0; i < list.length; i++) {
					if(list[i][0] == student) {
						studentIdx = i;
						break;
					}
				}

				int likeCnt = 0;
				for(int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if(ny >= n || nx >= n || ny < 0 || nx < 0) continue;

					for(int k = 1; k < 5; k++) {
						if(arr[ny][nx] == list[studentIdx][k]) {
							likeCnt++;
							break;
						}
					}
					
				}

				if(likeCnt == 0) continue;

				int temp = 1;
				for(int i = 1; i < likeCnt; i++) {
					temp *= 10;
				}
				
				score += temp;
			}
		}
		
		System.out.println(score);
	}
}