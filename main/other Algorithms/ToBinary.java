
import java.util.*;
import java.lang.*;
import java.io.*;

public final class Main {
    static int[] memo;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in=new Scanner(System.in);
	        int n=in.nextInt();
	       System.out.println(toBinary(n));
	}
	
	public static String toBinary(int n){
	    String binary="";
	    int rem=0;
	    while(n>0){
	        rem=n%2;
	        n=n/2;
	        binary=rem+binary;
	    }
	    return binary;
	}

}
