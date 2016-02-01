package graphtheory;

import java.util.ArrayList;
import java.util.List;

public class FriendScoreSRM436 {
	private static int[][] adjMatrix;
	
	public static void main(String[] args) {
		String[] friends = {"NYY",
							"YNY",
		 					"YYN"};
		
		System.out.println(highestScore(friends));
	}
	
	public static int highestScore(String[] friends) {
		int max = 0;
		adjMatrix = new int[friends.length][friends[0].length()];
		
		for(int i = 0; i < friends.length; i++) {
			char[] c = friends[i].toCharArray();
			
			for(int j = 0; j < c.length; j++) {
				adjMatrix[i][j] = c[j] == 'N' ? 0 : 1;
			}
		}
		
		for(int i = 0; i < friends.length; i++) {
			List<Integer> n = getNeighbors(i, friends.length);
			if(n.size() > max) {
				max = n.size();
			}
		}
		
		return max;
	}
	
	private static List<Integer> getNeighbors(int v, int size) {
		List<Integer> neighbors = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			for (int j=0; j < adjMatrix[v][i]; j++) {
				neighbors.add(i);
			}
		}
		
		return neighbors;
	}
	
	private static List<Integer> get2HopNeighbors(int v, int size) {
		List<Integer> neighbors = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			for (int j=0; j < adjMatrix[v][i]; j++) {
				neighbors.addAll(getNeighbors(i, size));
			}
		}
		
		return neighbors;
	}
}


