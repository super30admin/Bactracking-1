//Time Complexity : O(2^(m+n)), m -> candidates.length, n -> target
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> ans;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ans = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return ans;
		}

		List<Integer> combination = new ArrayList<Integer>();

		findCombinationsForLoop(candidates, 0, target, combination);
		return ans;
	}

	public void findCombinations(int[] candidates, int index, int target, List<Integer> combination) {
		// Base
		if (target == 0) {
			ans.add(new ArrayList<Integer>(combination));
			return;
		}
		if (index >= candidates.length || target < 0) {
			return;
		}
		// Don't choose
		findCombinations(candidates, index + 1, target, combination);
		// Choose
		combination.add(candidates[index]);
		findCombinations(candidates, index, target - candidates[index], combination);
		combination.remove(combination.size() - 1);
	}

	/***************************************************
	 * USING FOR LOOP ITERATOR VALUE AS PIVOT
	 ***************************************************/
	public void findCombinationsForLoop(int[] candidates, int index, int target, List<Integer> combinations) {
		if (target == 0) {
			ans.add(new ArrayList<Integer>(combinations));
		}

		if (target < 0) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			combinations.add(candidates[i]);
			findCombinationsForLoop(candidates, i, target - candidates[i], combinations);
			combinations.remove(combinations.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		int[] nums = { 2, 3, 5, 6, 7 };
		int target = 7;
		List<List<Integer>> combinations = obj.combinationSum(nums, target);

		System.out.println("Set of Combinations that sum up to " + target + ":");
		for (List<Integer> combination : combinations) {
			for (Integer num : combination) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
