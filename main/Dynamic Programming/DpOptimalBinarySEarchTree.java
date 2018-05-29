
// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    static int n;
    static int[][] memotable;
    static int[] keys;
    static int[] weights;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in=new Scanner(System.in);
	    n=in.nextInt();
	    memotable=new int[n][n];
	   keys=new int[n];
	   weights=new int[n];
	   for(int i=0;i<n;i++){
	       keys[i]=in.nextInt();
	       weights[i]=in.nextInt();
	   }
	   //considering the keys to be sorted, i.e. k1<k2<k3....
	   int searchCost=DpOBST(0,n-1);

		System.out.println(searchCost);
	}
	static int DpOBST(int i,int j){
	    if(i==j)
	    return weights[i];
	    
	    if(memotable[i][j]!=0)
	    return memotable[i][j];
	    
	    int min=Integer.MAX_VALUE;
	    
	    for(int k=i;k<=j;k++){
	        int val=0;
	        if(k==i){
	            val=DpOBST(k+1,j);
	        }
	        else if(k==j){
	            val=DpOBST(i,k-1);
	        }
	        else{
	        val=Math.min(DpOBST(i,k-1)+DpOBST(k+1,j),min);
	        }
	        if(val<min){
	        min=val;
	        }
	    }
	 
	    memotable[i][j]=min+sumWeights(i,j);
	    return min+sumWeights(i,j);
	}
	static int sumWeights(int i,int j){
	    int sum=0;
	    for(int k=i;k<=j;k++){
	        sum+=weights[k];
	   }
	    return sum;
	}
}