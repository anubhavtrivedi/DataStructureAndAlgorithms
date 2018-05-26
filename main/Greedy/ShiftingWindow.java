
import java.util.*;
import java.lang.*;
import java.io.*;


class ShiftingWindow{
    static int loc=0;
    static int windowSize=0;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		String input=in.nextLine();
		input=input.toLowerCase();
		System.out.println("length of the logest palindrom : "+LongestPalandromicSubString(input));
		System.out.println(input.substring(loc,loc+windowSize));
		
	}
	public static int LongestPalandromicSubString(String inp){
	    int len=0,temp;
	    for(int i=0;i<inp.length()-windowSize;i++){
	        temp=windowSize;
	        for(int j=i+windowSize;j<inp.length();j++){
	            if(isPalindrom(inp.substring(i,j+1))){
	                windowSize=Math.max(windowSize,j-i+1);
	            }
	        }
	       if(temp!=windowSize){
	       loc=i;
	       temp=windowSize;
	       }
	    }
	    return windowSize;
	   
	}
	public static boolean isPalindrom(String inp){
	    int len=inp.length();
	    for(int k=0;k<=len/2;k++){
	     if(inp.charAt(k)!=inp.charAt(len-k-1))
	     return false;
	    }
	    return true;
	}
}