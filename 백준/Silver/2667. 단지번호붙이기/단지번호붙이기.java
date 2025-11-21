import java.io.*;
import java.util.*;

class Main {

	static int N;
	static int count;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}//for 문 닫힘
		}//for 문 닫힘

		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(arr[i][j] == 1) {
					count = 0;
					dfs(i, j);
					list.add(count);
				}//if 문 닫힘
				
			}//for 문 닫힘
			
		}//for 문 닫힘

		Collections.sort(list);
		System.out.println(list.size());
		for(int li : list) {
			System.out.println(li);
		}

		
	}//main 문 닫힘

	public static void dfs(int y, int x) {

		int[] arrX = {0, 0, -1, 1};
		int[] arrY = {1, -1, 0, 0};
		arr[y][x] = 0;
		count++;

		for(int i = 0; i < 4; i++) {
			int nx = x + arrX[i];
	    int ny = y + arrY[i];

			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (arr[ny][nx] == 1) {
                dfs(ny, nx);
          }//if 문 닫힘
			}//if 문 닫힘
		}//for 문 닫힘
		
	}//dfs메서드 닫힘
	
}