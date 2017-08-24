import java.util.Scanner;
/*
*Algorithm complexity O(nlg(n))
*input :
*n 				no of elements
* x x x x x x x ... x		n elements to be sorted	
* for execution:
* 1. go to any onlie ide like:
*    -http://ide.geeksforgeeks.org/index.php
* 2. paste the code into the editor
* 3. set custom input as:
*		 10
*		 45 34 7 33 4 7 3 6 3 999
*/

public class MergeSort {
	public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        a=mergeSort(a);
        display(a);
    }
    
    public static int[] mergeSort(int[] a0){
       int n0,i,j,ind=0,top,n=a0.length;
       if(n==1)
        return a0;
       n0=(n/2);
       int[] a=new int[n0];
       int[] b=new int[n-n0];
       top=0;
       //divide step
       for(int i1=0;i1<n;i1++){
           if(ind<n0){
               a[ind]=a0[i1];
               ind++;
               //System.out.print("arr1"+a0[i1]+" ");
           }
           else{//System.out.print("arr2"+a0[i1]+" ");
               b[top]=a0[i1];
               top++;
           }
       }
       ind=0;
       a=mergeSort(a);
       b=mergeSort(b);
       //conqure
       i=0;j=0;
       while(i<n0&&j<top){
           if(a[i]>b[j]){
               a0[ind]=b[j];
               ind++; j++;
           }
           else{
               a0[ind]=a[i];
               i++; ind++;
           }
       }
       while(i<n0){
           a0[ind]=a[i];
           i++;
           ind++;
       }
       while(j<top){
           a0[ind]=b[j];
           j++;
           ind++;
       }
      return a0;
    }
    
    public static void display(int[] a){
        System.out.println("Sorted array is :");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }

}

