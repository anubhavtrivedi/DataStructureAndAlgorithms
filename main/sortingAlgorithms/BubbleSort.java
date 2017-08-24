import java.util.Scanner;
/*
*Algorithm complexity O(n^2)
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
public class BubbleSort {
	public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        a=bubbleSort(a);
        display(a);
    }
    
    public static int[] bubbleSort(int[] a){
        int flag;
        for(int i=0;i<a.length;i++){
            flag=0;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j+1]<a[j]){
                    a[j]=a[j]+a[j+1];
                    a[j+1]=a[j]-a[j+1];
                    a[j]=a[j]-a[j+1];
                    flag=1;
                }
            }
		/*
		*EARLY EXIT : if a pass over the array does not swap atleast one element than no furthe 
		* 	      passes will change the state of array as the array is already sorted.	
		*/
		
            if(flag==0)                     
            break;
        }
        return a;
    }
    
    public static void display(int[] a){
        System.out.println("Sorted array is :");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }

}

