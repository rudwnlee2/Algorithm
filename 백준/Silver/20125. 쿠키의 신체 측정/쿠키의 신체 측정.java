import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[][] arr = new char[n][n];
		boolean headCheck = false;
		int y = 0;
		int x = 0;

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			int count = 0;
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == '*' && !headCheck) {
					count++;
					y = i;
					x = j;
				}
			}

			if(count == 1 && !headCheck) {
				headCheck = true;
				y += 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(y + 1).append(" ").append(x + 1).append("\n");

		int count = 0;
		for(int i = x - 1; i >= 0; i--) {
			if(arr[y][i] == '*') count++;
			else break;
		}
		sb.append(count).append(" ");

		count = 0;
		for(int i = x + 1; i < n; i++) {
			if(arr[y][i] == '*') count++;
			else break;
		}
		sb.append(count).append(" ");

		count = 0;
		for(int i = y + 1; i < n; i++) {
			if(arr[i][x] == '*') count++;
			else break;
		}
		sb.append(count).append(" ");
		y += count;

		count = 0;
		for(int i = y + 1; i < n; i++) {
			if(arr[i][x - 1] == '*') count++;
			else break;
		}
		sb.append(count).append(" ");

		count = 0;
		for(int i = y + 1; i < n; i++) {
			if(arr[i][x + 1] == '*') count++;
			else break;
		}
		sb.append(count);
		
		System.out.println(sb);
	}
}