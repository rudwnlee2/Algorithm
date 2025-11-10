import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int count = 0;

		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(temp == 'A' || temp == 'B' || temp == 'C') {
				count += 3;
			} else if(temp == 'D' || temp == 'E' || temp == 'F') {
				count += 4;
			} else if(temp == 'G' || temp == 'H' || temp == 'I') {
				count += 5;
			} else if(temp == 'J' || temp == 'K' || temp == 'L') {
				count += 6;
			} else if(temp == 'M' || temp == 'N' || temp == 'O') {
				count += 7;
			} else if(temp == 'P' || temp == 'Q' || temp == 'R' || temp == 'S') {
				count += 8;
			} else if(temp == 'T' || temp == 'U' || temp == 'V') {
				count += 9;
			} else {
				count += 10;
			}
			
		}
		
		System.out.println(count);
	}
}