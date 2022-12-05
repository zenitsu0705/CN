import java.util.*;
public class dijkstrasAlgo {
    static final int V = 9;
	int minDistance(int dist[], Boolean sptSet[]){
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}
	void printSolution(int dist[]){
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}
	void dijkstra(int graph[][], int src){
		int dist[] = new int[V]; 
		Boolean sptSet[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		printSolution(dist);
	}
	public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int graph[][] = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    graph[i][j] = sc.nextInt();
                }
            }
            dijkstrasAlgo t = new dijkstrasAlgo();
            t.dijkstra(graph, 0);
        }
	}
}

// Output:
// 9 9
// 0 4 0 0 0 0 0 8 0
// 4 0 8 0 0 0 0 11 0
// 0 8 0 7 0 4 0 0 2
// 0 0 7 0 9 14 0 0 0
// 0 0 0 9 0 10 0 0 0
// 0 0 4 14 10 0 2 0 0
// 0 0 0 0 0 2 0 1 6
// 8 11 0 0 0 0 1 0 7
// 0 0 2 0 0 0 6 7 0
// Vertex           Distance from Source
// 0                0
// 1                4
// 2                12
// 3                19
// 4                21
// 5                11
// 6                9
// 7                8
// 8                14
