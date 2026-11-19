import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int y = 0, x = 0;
            int dir = 0;

            for (int num = 1; num <= n * n; num++) {
            	arr[y][x] = num;
                
            	int ny = y + dy[dir];
            	int nx = x + dx[dir];
                
                if(ny >= n || nx >= n || ny < 0 || nx < 0 || arr[ny][nx] != 0) {
                	dir = (dir + 1) % 4;
                	ny = y + dy[dir];
                	nx = x + dx[dir];
                }
                
                y = ny;
                x = nx;
            }

            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}