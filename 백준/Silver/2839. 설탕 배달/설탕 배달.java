import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int count = 0;
	    
	    while(n >= 0) {
	        if(n % 5 == 0) {
	            System.out.println(n / 5 + count);
                return;
	        } else {
	            n -= 3;
	            count++;
	        }
	    }
	    
	    if(n < 0) {
	        count = -1;
	    }
	    
	    System.out.println(count);
	}
}