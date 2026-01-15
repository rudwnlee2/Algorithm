import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
        
		int i = 1;
        
		while(i <= n) {
			System.out.println(i);
			i++;
		}
	}
}