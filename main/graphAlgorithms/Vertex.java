
import java.util.ArrayList;

public class Vertex {
	int largeValue=999999;
	public int name;
	public int distance;
	public ArrayList<Edge> edgeList;

	public Vertex(int i) {
		edgeList = new ArrayList<Edge>();
		name = i;
		distance = largeValue;
	}

}
