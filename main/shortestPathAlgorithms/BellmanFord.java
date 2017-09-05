import java.util.ArrayList;

public class BellmanFord {

	public static int bellmanFordShortestPath(int source, int dest, Vertex[] vert, int v) {
		ArrayList<Edge> edgeList;
		int v1, v2, x;
		vert[source].distance=0;
		for (int i = 1; i < v; i++) {
			for (int j = 1; j < v; j++) {
				edgeList = vert[j].edgeList;
				for (Edge e : edgeList) {
					v1 = e.v1;
					v2 = e.v2;
					if (v1 != j)
						x = v1;
					else
						x = v2;
					if (vert[x].distance > vert[j].distance + e.weight) {
						vert[x].distance = vert[j].distance + e.weight;
					}
				}
			}
		}
		for (int i = 1; i < v; i++) {
			for (int j = 1; j < v; j++) {
				edgeList = vert[j].edgeList;
				for (Edge e : edgeList) {
					v1 = e.v1;
					v2 = e.v2;
					if (v1 != j)
						x = v1;
					else
						x = v2;
					if (vert[x].distance > vert[j].distance + e.weight) {
						System.out.println(" Negative cycle detected !!");
						return -1;
					}
				}
			}
		}
		return vert[dest].distance;
	}
}
