

import java.util.*;
import java.lang.*;
import java.io.*;


class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner in= new Scanner(System.in);
	    int t=in.nextInt();
	    long a=in.nextLong();
	    long b=in.nextLong();
	    String as =toBinary(a);
	    String bs =toBinary(b);
	    
	    
	}
	private static String toBinary(long x){
	    int[] val=new int[100];
	    String ans="";
	    int top,temp=1,end=0;
	    while(x>0){
	        top=(int)(Math.log(x)/Math.log(2));
	        if(temp==1){
	            end=top;
	        }
	        temp++;
	       val[top]=1;
	        x-=Math.pow(2,top);
	         //System.out.println(x);
	        if(x==1){
	        val[0]=1;
	        break;
	        }
	    }
	    for(int i=end;i>=0;i--){
	       ans+=""+val[i];
	    }
	    System.out.println(ans);
	    return ans;
	}
}