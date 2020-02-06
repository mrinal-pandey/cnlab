import java.util.*;
class BellmanFord{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		BellmanFord obj = new BellmanFord();
		System.out.println("Enter the number of vertices: ");
		int V = in.nextInt();
		int[][] cost = new int[V + 1][V + 1];
		System.out.println("\nEnter cost matrix: ");
		for(int i = 1; i <= V; ++i){
			for(int j = 1; j <= V; ++j){
				cost[i][j] = in.nextInt();
			}
		}
		int[] distance = new int[V + 1];
		distance[1] = 0;
		for(int i = 2; i <= V; ++i){
			distance[i] = cost[1][i];
		}
		obj.bellmanFord(cost, distance, V);
		System.out.println("\nCosts:");
		for(int i = 1; i <= V; ++i){
			System.out.println("1 -> " + i + " : " + distance[i]);
		}
	}
	void bellmanFord(int[][] cost, int[] distance, int V){
		for(int k = 1; k < V - 1; ++k){
			for(int j = 2; j <= V; ++j){
				int min = Integer.MAX_VALUE;
				for(int i = 1; i <= V; ++i){
					if(distance[i] + cost[i][j] < min){
						min = distance[i] + cost[i][j];
					}
				}
				distance[j] = (distance[j] < min) ? distance[j] : min;
			}
		}
	}
}
