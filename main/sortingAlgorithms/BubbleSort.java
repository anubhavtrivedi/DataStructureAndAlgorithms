package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

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
            for(int j=i;j<a.length-1;j++){
                if(a[j+1]<a[j]){
                    a[j]=a[j]+a[j+1];
                    a[j+1]=a[j]-a[j+1];
                    a[j]=a[j]-a[j+1];
                    flag=1;
                }
            }
            if(flag==0)                     //early exit
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

