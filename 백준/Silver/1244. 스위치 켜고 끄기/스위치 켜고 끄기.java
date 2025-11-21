import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			if(check == 1) {
				int man = Integer.parseInt(st.nextToken());
				
				for(int j = man; j <= n; j += man) {
					if(arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			} else {
				int female = Integer.parseInt(st.nextToken());
				
				if(arr[female] == 0) {
					arr[female] = 1;
				} else {
					arr[female] = 0;
				}
				int start = female - 1;
				int end = female + 1;
				
				while(true) {
					if(start < 1 || end > n) break;
					
					if(arr[start] == arr[end]) {
						if(arr[start] == 0) {
							arr[start] = 1;
						} else {
							arr[start] = 0;
						}
						
						if(arr[end] == 0) {
							arr[end] = 1;
						} else {
							arr[end] = 0;
						}
						start--;
						end++;
					} else {
						break;
					}
				}
			}
			
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
	
}