import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			arr[y][x] = 1;
		}

		int l = Integer.parseInt(br.readLine());
		Map<Integer, Character> map = new HashMap<>();
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			map.put(t, c);
		}

		int headY = 0;
		int headX = 0;

		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};

		int dir = 0;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});

		int time = 0;
		while(n > 0) {

			int ny = dy[dir] + headY;
			int nx = dx[dir] + headX;
			time++;

			if(ny >= n || nx >= n || ny < 0 || nx < 0) {
				break;
			}

			for(int[] body : q) {
				if(body[0] == ny && body[1] == nx) {
					System.out.println(time);
					return;
				}
			}

			if(arr[ny][nx] == 0) {
				q.poll();
			} else {
				arr[ny][nx] = 0;
			}

			q.offer(new int[] {ny, nx});
			headY = ny;
			headX = nx;

			if(map.containsKey(time)) {
				if(map.get(time) == 'L') {
					dir = dir - 1;
					if(dir == -1) dir = 3;
				} else {
					dir = (dir + 1) % 4;
				}
			}

		}
				
		System.out.println(time);
	}
}