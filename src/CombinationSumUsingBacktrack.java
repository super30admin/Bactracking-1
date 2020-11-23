import java.util.ArrayList;
import java.util.List;

public class CombinationSumUsingBacktrack {

	List<List<Integer>> result1 ;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		result1 = new ArrayList<>();
		if (candidates.length == 0 || candidates == null)
			return result1;

		backtrack(candidates, target, 0, new ArrayList<Integer>(), 0);

		return result1;
	}

	private void backtrack(int[] candidates, int target, int sum, List<Integer> temp, int index) {
		// TODO Auto-generated method stub
		// base

		if (sum == target) {
			result1.add(new ArrayList<Integer>(temp) );
			return;
		}
		if (sum > target) {
			return;
		}
		// logic
		for (int i = index; i < candidates.length; i++) {
			// action
			temp.add(candidates[i]);
			// recurse
			backtrack(candidates, target, sum + candidates[i], temp, i);
			// backtrack
			temp.remove(temp.size() - 1);
		}

	}
}
