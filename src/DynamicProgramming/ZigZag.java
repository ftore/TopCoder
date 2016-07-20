package DynamicProgramming;

import java.util.Arrays;

public class ZigZag {
	public static void main(String[] args) {
		int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(longestZigZag(nums));
	}
	
	public static int longestZigZag(int[] nums) {
		if(nums.length <= 0) return 0;
		int longest = 1;
		int[][] Z = new int[nums.length][2];
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(nums[j] > nums[i]) {
					Z[i][0] = Math.max(Z[j][1] + 1, Z[i][0]);
				}
				if(nums[j] < nums[i]) {
					Z[i][1] = Math.max(Z[j][0] + 1, Z[i][1]);
				}
			}
			longest = Math.max(Z[i][0], Z[i][1]);
			
		}
		
		return longest;
	}
}
