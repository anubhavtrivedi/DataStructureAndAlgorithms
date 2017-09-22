package binarySearch;

public class BinarySearch {
    public static void main(String[] args){
        int[] a=new int[100];
        for(int i=0;i<100;i++){
            a[i]=i;
        }
        System.out.println(binarySearch(a,23));
        System.out.println(binarySearch(a,123));
    }
    /*
    * function takes in SORTED array and the element to search and return the Index
    * of the element if it exists in the array ..else returns -1
    */
    public static int binarySearch(int[] a,int x){
        int high,low=0,mid;
        high=a.length-1;
        while(high>=low){
            mid=high+low;
            if(a[mid]==x)
             return mid;
             else if(x>a[mid])
             low=mid+1;
             else
             high=mid-1;
        }
        return -1;
    }
}
