import java.io.*;
import java.util.*;

class Main {

	static int[] number;
	static int[] calculation;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		number = new int[n];
		calculation = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			calculation[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, number[0]);
		System.out.println(max);
		System.out.println(min);
		
	}

	static void dfs(int index, int current) {
		if(index == number.length) {
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}

		for(int i = 0; i < 4; i++) {
			if(calculation[i] > 0) {
				calculation[i]--;
				int next;
				if(i == 0) {
					next = current + number[index];
				} else if(i == 1) {
					next = current - number[index];
				} else if(i == 2) {
					next = current * number[index];
				} else {
					next = current / number[index];
				}
				dfs(index + 1, next);
				calculation[i]++;
			}
		}
		
	}
	
}