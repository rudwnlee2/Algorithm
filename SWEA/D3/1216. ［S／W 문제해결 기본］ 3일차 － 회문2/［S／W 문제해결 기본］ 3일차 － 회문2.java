import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int t = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[100][100];
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			int max = 1;
			boolean found = false;
			
			for(int len = 100; len > 1; len--) {
				
				if(found) break; 
				
				for(int i = 0; i < 100; i++) {
					if(found) break;
					
					for(int j = 0; j <= 100 - len; j++) {
						boolean check = true;
						for(int k = 0; k < len / 2; k++) {
							if(arr[i][j + k] != arr[i][j + len - 1 - k]) {
								check = false;
								break;
							}
						}
						
						if(check) {
							max = len;
							found = true;
							break;
						}
					}
				}

				if(!found) {
					for(int j = 0; j < 100; j++) {
						if(found) break;
						
						for(int i = 0; i <= 100 - len; i++) {
							boolean check = true;
							for(int k = 0; k < len / 2; k++) {
								if(arr[i + k][j] != arr[i + len - 1 - k][j]) {
									check = false;
									break;
								}
							}
							
							if(check) {
								max = len;
								found = true;
								break;
							}
						}
					}
				}
			}
			
			
			System.out.println("#" + t + " " + max);
		}
	}
}