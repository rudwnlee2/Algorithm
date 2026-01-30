import java.io.*;
import java.util.*;

class Main {

	static int n;
	static int m;

	static List<int[]> chickens = new ArrayList<>();
	static List<int[]> hous = new ArrayList<>();
	static boolean[] selected;

	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					hous.add(new int[] {i, j});
				} else if(temp == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}

		selected = new boolean[chickens.size()];
		back(0, 0);
		System.out.println(min);
	}

	private static void back(int start, int depth) {
		if(depth == m) {
			calculate();
			return;
		}

		for(int i = start; i < chickens.size(); i++) {
			selected[i] = true;
			back(i + 1, depth + 1);
			selected[i] = false;
		}
		
	}

	private static void calculate() {
		int total = 0;

		for(int[] h :  hous) {
			int tempMin = Integer.MAX_VALUE;

			for(int i = 0; i < chickens.size(); i++){
				if(selected[i]) {
					int[] c = chickens.get(i);
					int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
					tempMin = Math.min(tempMin, dist);
				}
			}

			total += tempMin;
			if(total >= min) return;
		}

		min = Math.min(min, total);
	}

}