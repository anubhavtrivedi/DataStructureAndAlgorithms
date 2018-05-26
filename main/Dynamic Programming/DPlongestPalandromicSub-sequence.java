import java.util.*;
import java.lang.*;
import java.io.*;

class DP{
    static int[][] memo;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		String input=in.nextLine();
		input=input.toLowerCase();
		memo=new int[input.length()][input.length()];
		int len=dpLongestPalandromicSubSequence(0,input.length()-1,input);
		System.out.println("length of the logest palindrom : "+len);
		
	}
	public static int dpLongestPalandromicSubSequence(int i,int j,String inp){
	    int temp=0;
	    if(memo[i][j]!=0){
	        return memo[i][j];
	    }
	    if(i==j){
	        memo[i][j]=1;
	        return 1;
	    }
	    if(inp.charAt(i)==inp.charAt(j)){
	        temp=2+dpLongestPalandromicSubSequence(i+1,j-1,inp);  
	        memo[i][j]=temp;
	        return temp;
	    }
	    else{
	        temp= Math.max(dpLongestPalandromicSubSequence(i+1,j,inp),dpLongestPalandromicSubSequence(i,j-1,inp));
	        memo[i][j]=temp;
	        return temp;
	        
	    }
	   
	}
}