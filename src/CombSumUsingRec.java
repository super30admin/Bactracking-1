import java.util.ArrayList;
import java.util.List;

public class CombSumUsingRec {

	List<List<Integer>> result;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0 || candidates == null) {
			return result;
		}
		result = new ArrayList<>();
		helper(candidates, target, 0, new ArrayList<>(), 0);

		return result;

	}

	private void helper(int[] candidates, int target, int sum, List<Integer> temp, int index) {
		// base
		if (index >= candidates.length || sum > target) {
			return;
		}

		if (sum == target) {
			result.add(temp);
			return;
		}

		// logic
		// dont choose
		helper(candidates, target, sum, new ArrayList<>(temp), index + 1);
		// choose
		temp.add(candidates[index]);
		helper(candidates, target, sum + candidates[index], new ArrayList<>(temp), index);

		// we can reverse the choose and dont choose
		// choose
//		List<Integer> temp2 = new ArrayList<Integer>();
//		temp2.add(candidates[index]);
//		helper(candidates, target, sum + candidates[index], temp2, index);
		// dont choose
//		helper(candidates, target, sum, new ArrayList<>(temp), index + 1);

	}

	public static void main(String[] args) {
		CombSumUsingRec rec = new CombSumUsingRec();
		rec.combinationSum(new int[] { 2, 3, 6, 7 }, 7);

	}
}
