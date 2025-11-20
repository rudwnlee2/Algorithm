import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static String max;
	static char[] arr;
	static int count;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int ts = 1; ts <= t; ts++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			count = Integer.parseInt(st.nextToken());
			
			arr = s.toCharArray();
			max = "0";
			
			dfs(0, 0);
			System.out.println("#" + ts + " " + max);
		}
	}
	
	private static void dfs(int index, int change) {
		
		if(change == count) {
			String s = new String(arr);
			if(s.compareTo(max) > 0) {
				max = s;
			}
			return;
		}
		
		for(int i = index; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				swap(i, j);
				dfs(i, change + 1);
				swap(i, j);
			}
		}
	}
	
	static void swap(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}