package euclidianGCD;

public class EuclidianGCD {
    public static void main(String[] args){
        System.out.println(euclidianGCD(90,60));
    }
    
    public static int euclidianGCD(int a,int b){
        int large,small,x;
        if(a>b){
            large=a;
            small=b;
        }
        else{
            large=b;
            small=a;
        }
        while(true){
            x=large%small;
            if(x==0)
            return small;
            else{
                large=small;
                small=x;
                return euclidianGCD(large,small);
            }
        }
    }
}
