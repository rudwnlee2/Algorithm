import java.io.*;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int temp = n / 3;
			System.out.println("#" + tc + " " + temp);
		}
	}
}