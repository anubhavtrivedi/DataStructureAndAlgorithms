
import java.util.*;
import java.lang.*;
import java.io.*;
/*
* The game starts with row of coins and a player can choose any of the two extreem coins in his turn. the goal here is to maximise the
* individual score.
*/
class Main {
    static int[] coin;
    static int[][] memo;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in=new Scanner(System.in);
	    int n=in.nextInt();
	    coin=new int[n];
	    memo=new int[n][n];
	    int total=0;
	    for(int i=0;i<n;i++){
	     coin[i]=in.nextInt();
	     total+=coin[i];
	    }
	    int winner=dpCoinGame(0,n-1);
	    System.out.println("winner score :"+winner);
	    System.out.println("looser score :"+(total-winner));    
	}
    static int dpCoinGame(int i,int j){
        if(j<i)
        return 0;
        if(i==j)
        return coin[i];
        if(memo[i][j]!=0)
        return memo[i][j];
        int max;
        if(j+1-i==3){
            int choice1=Math.min(coin[i+1],coin[j])+coin[i];
            int choice2=Math.min(coin[i],coin[i+1])+coin[j];
             max=Math.max(choice1,choice2);      
        }else{
            int choice1=Math.min(dpCoinGame(i+1,j-1),dpCoinGame(i+2,j))+coin[i];
            int choice2=Math.min(dpCoinGame(i,j-2),dpCoinGame(i+1,j-1))+coin[j];
             max=Math.max(choice1,choice2);
          
        }
        memo[i][j]=max;
        return max;
    }
}
