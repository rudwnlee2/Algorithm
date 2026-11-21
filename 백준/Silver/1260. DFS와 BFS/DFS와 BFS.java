import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static boolean[] visited;
	static int[][] arr;

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1][n + 1];
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int y = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	
        	arr[y][x] = 1;
        	arr[x][y] = 1;
        }
    	
        visited = new boolean[n + 1];
        dfs(v);
        
        System.out.println();
        
        visited = new boolean[n + 1];
        bfs(v);
    }
    
    public static void dfs(int v) {
    	visited[v] = true;
        System.out.print(v + " ");
        
        if(v == arr.length) return;
        
        for(int i = 1; i < arr.length; i++) {
        	if(arr[v][i] == 1 && visited[i] == false) dfs(i);
        }
    }
    
    public static void bfs(int v) {
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.add(v);
    	visited[v] = true;
        System.out.print(v + " ");
        
        while(!q.isEmpty()) {
        	int temp = q.poll();
        	for(int i = 1; i < arr.length; i++) {
        		if(arr[temp][i] == 1 && visited[i] == false) {
        			q.add(i);
        			visited[i] = true;
        			System.out.print(i + " ");
        		}
        	}
        }
    }
}