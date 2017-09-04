

public class BreathFirstSearch {
	public static void bfs(Vertex[] vert, int start, int n) {
		Vertex[] stack = new Vertex[n+1];
		int top = 0, bottm = 0, v1, v2;
		Vertex vt;
		int[] status = new int[n+1];
		stack[top] = vert[start];
		while (top >= bottm) {
			vt = stack[bottm];
			status[vt.name] = 1;
			bottm++;

			System.out.println(vt.name);

			for (Edge e : vt.edgeList) {
				v1 = e.v1;
				v2 = e.v2;
				if (status[v1] == 0) {
					status[v1] = 1;
					top++;
					stack[top] = vert[v1];
				}
				if (status[v2] == 0) {
					status[v2] = 1;
					top++;
					stack[top] = vert[v2];
				}

			}

		}
	}
}
