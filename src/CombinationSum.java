// Time Complexity :O(2^n) for both backtracking and recursive
// Space Complexity :O(n) for backtracking , O(n*2^n) for recursive
// Did this code successfully run on Leetcode :yes

/*
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
	List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		res = new ArrayList<>();
		if(candidates == null || candidates.length == 0) return res;

		recursive(candidates, target, new ArrayList<>(), 0, 0);
		return res;
	}

	private void recursive(int[] candidates, int target, List<Integer> temp, int currSum, int index) {

		//base
		if(currSum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if(index >= candidates.length || currSum > target){
			return;
		}

		//logic
		//do not use current number

		recursive(candidates, target, new ArrayList<>(temp), currSum, index + 1);
		
		//use current number
		temp.add(candidates[index]);
		recursive(candidates, target, new ArrayList<>(temp), currSum + candidates[index], index);
	}

	private void backtrack(int[] candidates, int target, List<Integer> temp, int currSum, int index) {

		//base
		if(currSum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if(index >= candidates.length || currSum > target){
			return;
		}

		//logic
		//do not use current number

		backtrack(candidates, target, temp, currSum, index + 1);
		
		//use current number

		temp.add(candidates[index]);
		backtrack(candidates, target, temp, currSum + candidates[index], index);

		//backtrack stage - remove added value from temp when recursion unwinds
		temp.remove(temp.size() - 1);
	}
}
