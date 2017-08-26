package vanEmdeBoas;

public class VebTree {
    static VebNode root;
/*
 * Van emde Boas tree complexity  	insert:O(loglog(u))
 * 									succesor:O(loglog(u))
 */
    public static void main(String args[]){
        root=new VebNode(16);
       
       //for testing
        insertVeb(4);
        insertVeb(12);
        insertVeb(13);
        insertVeb(14);
        insertVeb(1);
        insertVeb(3);
       insertVeb(5);  
        insertVeb(8);
       insertVeb(9);
        insertVeb(10);
        insertVeb(2);
        System.out.println("tree min: "+minVeb());
        System.out.println("tree max: "+maxVeb());
        System.out.println(succesorVeb(1));
         System.out.println(succesorVeb(7));
         System.out.println(succesorVeb(3));
         
    }
    
    private static int minVeb() {
		return root.min;
	}

	private static int maxVeb() {
		return root.max;
	}

	private static int succesorVeb(int x) {
		return succesor(root,x);
	}

	public static void insertVeb(int x) {
    	insert(root,x);
    }
    public static int succesor(VebNode v,int x){
    	if(x>v.max) {
    		System.out.println("not found !");
    		return -1;
    	}
        if(x<v.min)
            return v.min;
        if(v.squ==0)		//for the case of no successor
        	return -1;
        int i=(int)(x/v.squ);
        int j=(int)(x%v.squ);
        if(v.cluster[i]==null) {
        	   i=succesor(v.summary,i);
        	   if(i==-1)
               	return -1;
               j=v.cluster[i].min;
        }
        else if(j<v.cluster[i].max)
            j=succesor(v.cluster[i],j);
        else{
            i=succesor(v.summary,i);
            if(i==-1)
            	return -1;
            j=v.cluster[i].min;
        }
        return (int)(i*(v.squ)+j);
    }

    // i - high             j- low
    public static void insert(VebNode v,int x){
        int temp;
        int i=(int)(x/v.squ);
        int j=(int)(x%v.squ);
        if(v.min==-1){
            v.min=v.max=x;
            return;
        }
        if(x<v.min){
            temp=v.min;
            v.min=x;
            x=temp;
            i=(int)(x/v.squ);
            j=(int)(x%v.squ);
        }
        if(x>v.max)
            v.max=x;
        if(v.cluster[i]==null){
            v.cluster[i]=new VebNode((int)v.squ);
            insert(v.summary,i);
        }
        insert(v.cluster[i],j);
    }

}
