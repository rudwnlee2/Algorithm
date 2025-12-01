import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if(n < 100) {
			System.out.println(n);
			return;
		}
		
		int count = 99;
		for(int i = 100; i <= n; i++) {
			if((i / 100) - (i / 10) % 10 == (i / 10) % 10 - i % 10) count++;
		}

		System.out.println(count);
	}
}