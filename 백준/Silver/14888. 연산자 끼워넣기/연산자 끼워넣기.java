import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int[] op;
	static int[] arr;
	static int max;
	static int min;
	static int n;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(int index, int num) {
		if(index == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0 && i == 0) {
				op[i] -= 1;
				dfs(index + 1, num + arr[index]);
				op[i] += 1;
			} else if(op[i] > 0 && i == 1) {
				op[i] -= 1;
				dfs(index + 1, num - arr[index]);
				op[i] += 1;
			} else if((op[i] > 0 && i == 2)) {
				op[i] -= 1;
				dfs(index + 1, num * arr[index]);
				op[i] += 1;
			} else if (op[i] > 0){
				op[i] -= 1;
				dfs(index + 1, num / arr[index]);
				op[i] += 1;
			}
		}
		
	}
	
}