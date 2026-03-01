import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int[] arr = new int[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		int max = 0;
		int index = 0;
		
		int count = 0;
		
		for(int i : arr) {
			count++;
			if(i > max) {
				max = i;
				index = count;
			}
		}
 
		System.out.println(max);
		System.out.println(index);
 
	}
}