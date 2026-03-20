import java.io.*;
import java.util.*;

class Main {
	static char[][] arr = new char[5][8];
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		for(int i = 0; i < 8; i++) arr[1][i] = s.charAt(i);

		s = br.readLine();
		for(int i = 0; i < 8; i++) arr[2][i] = s.charAt(i);

		s = br.readLine();
		for(int i = 0; i < 8; i++) arr[3][i] = s.charAt(i);

		s = br.readLine();
		for(int i = 0; i < 8; i++) arr[4][i] = s.charAt(i);
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			visited = new boolean[5];
			visited[num] = true;
			
			if(dir == 1) {
				clockwise(num);
			} else {
				counterclockwise(num);
			}
			
		}

		int score = 0;
		for(int i = 1; i <= 4; i++) {
			if(arr[i][0] == '1') {
				score += (int) Math.pow(2, i - 1);
			}
		}
		
		System.out.println(score);
	}

	private static void clockwise(int num) {
		if(num == 1) {
			if(!visited[2] && arr[1][2] != arr[2][6]) {
				visited[2] = true;
				counterclockwise(2);
			}
		} else if(num == 4) {
			if(!visited[3] && arr[4][6] != arr[3][2]) {
				visited[3] = true;
				counterclockwise(3);
			}
		} else {
			if(!visited[num + 1] && arr[num][2] != arr[num + 1][6]) {
				visited[num + 1] = true;
				counterclockwise(num + 1);
			}

			if(!visited[num - 1] && arr[num][6] != arr[num - 1][2]) {
				visited[num - 1] = true;
				counterclockwise(num - 1);
			}
		}

		char temp = arr[num][7];
		for(int i = 7; i > 0; i--) {
			arr[num][i] = arr[num][i - 1];
		}
		arr[num][0] = temp;
		
	}

	private static void counterclockwise(int num) {
		if(num == 1) {
			if(!visited[2] && arr[1][2] != arr[2][6]) {
				visited[2] = true;
				clockwise(2);
			}
		} else if(num == 4) {
			if(!visited[3] && arr[4][6] != arr[3][2]) {
				visited[3] = true;
				clockwise(3);
			}
		} else {
			if(!visited[num + 1] && arr[num][2] != arr[num + 1][6]) {
				visited[num + 1] = true;
				clockwise(num + 1);
			}

			if(!visited[num - 1] && arr[num][6] != arr[num - 1][2]) {
				visited[num - 1] = true;
				clockwise(num - 1);
			}
		}

		char temp = arr[num][0];
		for(int i = 0; i < 7; i++) {
			arr[num][i] = arr[num][i + 1];
		}
		arr[num][7] = temp;

	}

}