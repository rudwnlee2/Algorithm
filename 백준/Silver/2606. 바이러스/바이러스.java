import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static List<Integer>[] arr;
	static int count;
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		arr = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		count = 0;
		dfs(1);
		
		System.out.println(count - 1);
	}
	
	private static void dfs(int index) {
		visited[index] = true;
		
		count++;
		for(int i = 0; i < arr[index].size(); i++) {
			int temp = arr[index].get(i);
			if(!visited[temp]) {
				dfs(temp);
			}
		}
	}
	
}