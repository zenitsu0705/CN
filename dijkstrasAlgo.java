import java.util.*;
public class dijkstrasAlgo {
	public static void Dijkstra(int[][] adjacencyMatrix){
		int v = adjacencyMatrix.length;
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		distance[0]=0;
		for(int i=1;i<v;i++){
			distance[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<v-1;i++){
			int minVertex = findMinVertex(distance,visited);
			visited[minVertex]=true;
			for(int j=0;j<v;j++){
				if(adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
					int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
					if(newDist < distance[j]){
						distance[j] = newDist;
					}
				}
			}
		}
		System.out.println("Vertex"+"\t"+"Distance");
		for(int i=0;i<v;i++){
			System.out.println(i +"\t"+ distance[i]);
		}
	}
	public static int findMinVertex(int[] distance, boolean visited[]){
		int minVertex = -1;
		for(int i=0;i<distance.length;i++){
			if(!visited[i] && (minVertex==-1 || distance[i] < distance[minVertex])){
				minVertex=i;
			}
		}
		return minVertex;
	}
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int adjacencyMatrix[][] = new int[v][v];
		for(int i=0;i<e;i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			adjacencyMatrix[v1][v2]=weight;
			adjacencyMatrix[v2][v1]=weight;
		}
		Dijkstra(adjacencyMatrix);
	}
}
// Output:
// 5 7
// 0 1 4
// 0 2 8
// 1 3 5
// 1 2 2
// 2 3 5
// 2 4 9
// 3 4 4
// Vertex  Distance
// 0       0
// 1       4
// 2       6
// 3       9
// 4       13