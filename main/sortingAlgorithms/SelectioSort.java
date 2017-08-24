package sortingAlgorithms;
import java.util.ArrayList;
import java.util.Scanner;

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

