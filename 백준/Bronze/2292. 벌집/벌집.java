import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		if(n == 1) {
			System.out.println(1);
			return;
		}

		int count = 1;
		int num = 2;
		
		while(true) {
			if(num > n) {
				break;
			}

			num += count * 6;
			count++;
		}
		
		System.out.println(count);
	}
}