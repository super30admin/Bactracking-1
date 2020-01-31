// time complexity is O(2^ n*m) i.e the number of coins and the target
// Space complexity is O(n+m) 
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN66UniqueCombinationofCandidate {
		List<List<Integer>> result = new ArrayList<>();

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			// edge case
			if (candidates == null || candidates.length == 0)
				return result;
			backtracking(candidates, target, 0, 0, new ArrayList<Integer>());
			return result;
		}

		private void backtracking(int[] candidates, int target, int sum, int index, List<Integer> temp) {
			// base case
			if (sum == target) {
				result.add(new ArrayList<>(temp));
				return;
			}
			if (sum > target)
				return;
			// logic
			for (int i = index; i < candidates.length; i++) {
				temp.add(candidates[i]);
				backtracking(candidates, target, sum + candidates[i], i, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}