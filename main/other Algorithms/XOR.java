
import java.util.*;
import java.lang.*;
import java.io.*;

public final class Main {
    static int[] memo;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in=new Scanner(System.in);
	        int x=in.nextInt();
	        int y=in.nextInt();
	       System.out.println(xor(x,y));
	}
	
	public static String xor(int x,int y){
	    String xor="";
	    String n=toBinary(x);
	    String m=toBinary(y);
	    x=0;
	    y=0;
	    while(x<n.length()&&y<m.length()){
	        if((n.charAt(x)=='0'&&m.charAt(y)=='0')||(n.charAt(x)=='1'&&m.charAt(y)=='1')){
	            xor+="0";
	        }
	        else{
	            xor+="1";
	        }
	        x++;y++;
	    }
	    while(x<n.length()){
	        xor+=n.charAt(x);
	        x++;
	    }
	    while(y<m.length()){
	        xor+=m.charAt(y);
	        y++;
	    }
	    return xor;
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
