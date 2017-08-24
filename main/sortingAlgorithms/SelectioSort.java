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
public class SelectioSort {
	public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        a=selectioSort(a);
        display(a);
    }
    
    public static int[] selectioSort(int[] a){
        int max,index,temp;
        for(int i=0;i<a.length;i++){
            max=a[i];index=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]>max){
                    max=a[j];
                    index=j;
                }
            }
            temp=a[i];
            a[i]=a[index];
            a[index]=temp;
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

