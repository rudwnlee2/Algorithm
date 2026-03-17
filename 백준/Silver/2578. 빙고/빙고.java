import java.io.*;
import java.util.*;

class Main {
	static boolean[][] visited = new boolean[5][5];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr1 = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] arr2 = new int[25];
		int index = 0;
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr2[index] = Integer.parseInt(st.nextToken());
				index++;
			}
		}

		index = 0;
		while(index <= 25) {
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(arr2[index] == arr1[i][j]) {
						visited[i][j] = true;
						index++;
						if(check()) {
							System.out.println(index);
							return;
						}
					}
				}
			}
			
		}
		
	}

	public static boolean check() {
		int count = 0;

		for(int i = 0; i < 5; i++) {
			int countX = 0;
			int countY = 0;
			for(int j = 0; j < 5; j++) {
				if(visited[i][j]) countX++;
				if(visited[j][i]) countY++;
			}

			if(countX == 5) count++;
			if(countY == 5) count++;
		}

		int countX = 0;
		int countY = 0;
		for(int i = 0; i < 5; i++) {
			if(visited[0 + i][0 + i]) countX++;
			if(visited[4 - i][0 + i]) countY++;
		}

		if(countX == 5) count++;
		if(countY == 5) count++;

		if(count >= 3) {
			return true;
		}
		return false;
	}
}