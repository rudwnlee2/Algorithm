import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			int result = 0;
			
			for(int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < size; i++) {
				boolean check = false;
				
				for(int j = 0; j < size; j++) {
					if(arr[j][i] == 1) {
						check = true;
					} else if (arr[j][i] == 2 && check) {
						result++;
						check = false;
					}
				}
			}
			
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}