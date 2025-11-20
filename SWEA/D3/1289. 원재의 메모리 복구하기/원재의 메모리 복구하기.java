import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++){
			String bit = br.readLine();
			
			int result = 0;
			char CBit = '0';
			
			for(int i = 0; i < bit.length(); i++) {
				char temp = bit.charAt(i);
				
				if(CBit != temp) {
					result++;
					CBit = temp;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}