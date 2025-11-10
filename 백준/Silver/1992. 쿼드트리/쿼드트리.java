import java.io.*;
class Main {

	static int[][] arr;

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		dfs(0,0,n);
		System.out.println(sb);
		
	}

	static void dfs(int startY, int startX, int size) {
		int sum = 0;
		for(int i = startY; i < startY + size; i++) {
			for(int j = startX; j < startX + size; j++) {
				sum += arr[i][j];
			}
		}

		if(sum == size * size) {
			sb.append(1);
			return;
		}
		
		if(sum == 0) {
			sb.append(0);
			return;
		}

		sb.append("(");
		dfs(startY, startX, size/2);
		dfs(startY, startX + size/2, size/2);
		dfs(startY + size/2 , startX, size/2);
		dfs(startY + size/2, startX + size/2, size/2);
		sb.append(")");
		
	}
}