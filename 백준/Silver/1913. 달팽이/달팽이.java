import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int position = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		int posY = 0;
		int posX = 0;
		int num = n * n;

		int[] dy = { 1, 0, -1, 0 }; 
		int[] dx = { 0, 1, 0, -1 };
		int y = 0;
		int x = 0;
		int d = 0;

		while(num > 0) {
			arr[y][x] = num;

			if(num == position) {
				posY = y + 1;
				posX = x + 1;
			}

			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0) {
				d = (d + 1) % 4;
				ny = y + dy[d];
				nx = x + dx[d];
			}

			y = ny;
			x = nx;
			num--;
			
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(posY + " " + posX);
		
	}
}