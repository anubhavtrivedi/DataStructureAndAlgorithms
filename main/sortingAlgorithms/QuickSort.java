package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
    static int[] a;
	public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        quickSort(0,n-1);
        display();
    }
    
    public static void quickSort(int start, int end){
         if(start>=end)
       return;
       int i,j,temp,pivot=a[end];
     
       i=start; 
       j=end-1;
       while(i<j){
           while(i<j){
               if(a[i]>pivot)
               break;
               i++;
           }
           while(j>i){
               if(a[j]<pivot)
               break;
               j--;
           }
            

           temp=a[i];
           a[i]=a[j];
           a[j]=temp;
       }
       if(a[i]<pivot)
       i++;
        temp=a[i];
           a[i]=a[end];
           a[end]=temp;
        quickSort(start,i-1);
        quickSort(i+1,end);
    }
    
    public static void display(){
        System.out.println("Sorted array is :");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }

}

