import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		int line = 1;
		while(x > line) {
			x -= line;
			line += 1;
		}

		if(line % 2 == 0) {
			System.out.println(x + "/" + (line - x + 1));
		} else {
			System.out.println((line - x + 1) + "/" + x);
		}
		
	}
}