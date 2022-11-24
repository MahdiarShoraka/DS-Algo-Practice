package Practice;

class Solution {
	/*
	 * @author Mahdiar Shoraka
	 * This class provide coding solutions for EEECS 3101 A3 problems.
	 * Problems are provided by Prof Larry Zhang at Lassonde School of Engineering.
	 */
	public int maxSubLeveledUp(int[] nums) {
		int[] curSum = new int[nums.length];
		int[] bestSum = new int[nums.length];
		curSum[0] = nums[0];
		bestSum[0] = nums[0];
		int j = 0;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] < 0 && j == 0) {
				curSum[i] = curSum[i - 1] - nums[i];
				j = i;
			} else if (nums[i] < 0 && j != 0) {
				curSum[i] = curSum[i - 1] - nums[i] - curSum[j];
				j = i;

			} else {
				curSum[i] = Math.max(curSum[i - 1] + nums[i], nums[i]);
			}
			System.out.print(curSum[i] + " ");
			bestSum[i] = Math.max(curSum[i], bestSum[i - 1]);
			System.out.print(bestSum[i]);
			System.out.println();
		}
		return bestSum[nums.length - 1];
	}

	public int coinGame(int[] coins) {
		int s = 1;
		int[] ans = new int[coins.length];
		int t = 0;
		int q = 0; 
		int[] sum = new int[coins.length];
		sum[0] = coins[0];
		for(int i=1; i<sum.length; i++) {
			sum[i] += sum[i-1] + coins[i];
		}
		
		for (int j = 0; j < coins.length; j++) {
			t = Math.min(2*s, j);
			for(int i=1; i<t; i++) {
				q = Math.max(q,ans[i-1] - sum[j]);
			}
			ans[j] = q;
		}
		
		return ans[coins.length-1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		//int[] nums = { 2, -3, 1, -4, 3 };
		int[] a = { 3, 6, 8, 5, 4 };
		int r = s.coinGame(a);
		System.out.println("Answer: " + r);

	}
}
