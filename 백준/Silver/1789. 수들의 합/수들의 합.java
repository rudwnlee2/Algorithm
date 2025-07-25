import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		long sum = 0;
		int count = 0;

		for(int i = 1; i <= s; i++) {
			if(sum + i > s) break;
			count++;
			sum += i;
		}

		System.out.println(count);
		
	}
}