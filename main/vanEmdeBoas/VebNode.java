package vanEmdeBoas;


public class VebNode {
    int u;
    int min;
    int max;
    int  squ;
    VebNode summary;
    VebNode[] cluster;
 
public VebNode(int x){
	u=x;
	min=max=-1;
	if(x==1)
		return;
	if(x==2)
		squ=1;
	else {
		squ=(int)(Math.sqrt(u)+1);
	}
   cluster =new VebNode[squ];
 summary= new VebNode(squ);
 
   }
}
