/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    int ans;
	    Scanner in= new Scanner(System.in);
	    
	    int n = in.nextInt();
	    int[][] bag=new int[2][n];
	    
	    for(int i=0;i<n;i++){
	        bag[0][i]= in.nextInt();
	        bag[1][i]= in.nextInt();
	    }
        
        
        	    
		System.out.println(solve(bag,n-1, 10));
	}
	
    static	int[][] dp=new int [10][25];
	
	public static int solve(int[][] bag,int n,int c){
	    if(n<0||c<=0)
	    return 0;
	    int ans=0;
	    
	    if(dp[n][c]!=0){
	        System.out.println(n+" "+c);
	        return dp[n][c];
	        
	    }
	        
	   if(bag[0][n]>c){
	       ans=solve(bag,n-1,c);
	   }
	   else{
	       ans=Math.max(bag[1][n]+solve(bag,n-1,c-bag[0][n]),solve(bag,n-1,c));
	   }
	   dp[n][c]=ans;
	   return ans;
	   
	}
}



