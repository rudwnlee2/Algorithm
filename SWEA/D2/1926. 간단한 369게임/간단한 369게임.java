import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			
			if (s.contains("3") || s.contains("6") || s.contains("9")) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
                        System.out.print("-");
                    }
                    
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
			
		}
		
	}
}