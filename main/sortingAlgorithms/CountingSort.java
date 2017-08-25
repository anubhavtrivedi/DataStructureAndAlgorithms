import java.util.Scanner;
/*
*Algorithm complexity O(u)  were u is the size of the universe 
* 		      O(n) for 'n' of the order of 'u'	
*input :
* range n 				range of the key universe  and no of elements
* x x x x x x x ... x		n elements to be sorted	
* for execution:
* 1. go to any onlie ide like:
*    -http://ide.geeksforgeeks.org/index.php
* 2. paste the code into the editor
* 3. set custom input as:
*		 1000 10
*		 45 34 7 33 4 7 3 6 3 999
*/
public class CountingSort {
	public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int range =in.nextInt();
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        a=countingSort(a,range);
        display(a);
    }
    
    public static int[] countingSort(int[] a,int range){
        int[] aux=new int[range+1];
        int top=0;
        //initializing auxilary array
        for(int i=0;i<a.length;i++){
            aux[a[i]]++;
        }
        //constructing sorted array
        for(int i=0;i<=range;i++){
            if(aux[i]!=0){
                while(aux[i]>0){
                    a[top]=i;
                    aux[i]--;
                    top++;
                }
            }
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

