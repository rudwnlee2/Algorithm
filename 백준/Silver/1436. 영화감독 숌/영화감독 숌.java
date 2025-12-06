import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int result = 0;
		int num = 0;
		while(result != n) {
			num++;

			if(String.valueOf(num).contains("666")) {
				result++;
			}
		}
		
		System.out.println(num);
	}
}