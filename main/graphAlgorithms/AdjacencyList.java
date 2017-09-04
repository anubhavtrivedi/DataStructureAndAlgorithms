
/*
 * the function adjList takes in an adjacency matrix and returns its equivalent adjacency list
 */
public class AdjacencyList {

	public static Vertex[] adjList(int[][] adjMatrix, int n) {
		Vertex[] vert = new Vertex[n+1];
		for (int i = 1; i <= n; i++) {
			vert[i] = new Vertex(i);
		}
		Edge edge;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (adjMatrix[i][j] != 0) {
					edge = new Edge(i, j, adjMatrix[i][j]);
					vert[i].edgeList.add(edge);
					vert[j].edgeList.add(edge);
				}
			}
		}
		return vert;
	}
}
