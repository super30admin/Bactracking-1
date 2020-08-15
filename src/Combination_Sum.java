import java.util.*;
/********************************************Using Backtracking*******************************************/
//Time Complexity : O(2^n),  n is the length of the candidates array.
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using Backtracking, Since repeated numbers are allowed, add a number into list and keep adding until the sum is greater than equal to target value
 * Then backtrack(remove the numbers added in temp list) and add numbers at other indices and check whether sum equals target value.*/

public class Combination_Sum {
	static List<List<Integer>> result;
	static int targ;
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		targ = target;
		//edge case
		if(candidates == null || candidates.length == 0)
			return result;

		backtrack(candidates, new ArrayList<>(), 0, 0);	//calling function on the given array, using a temp list, sum and index to track the candidates array
		return result;
	}

	private static void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
		//base
		if(sum > targ || index >= candidates.length)
			return;

		if(sum == targ){
			result.add(new ArrayList<>(temp));	// add the copy of temp till the point to result
			return;
		}

		//logic
		for(int i=index; i<candidates.length; i++){
			//action
			temp.add(candidates[i]);

			//recurse
			backtrack(candidates, temp, sum + candidates[i], i);	//calling recursive function with increasing sum, new temp and on index as i

			//backtrack
			temp.remove(temp.size()-1);	//return back to one step back when base case hits, to traverse other possible paths
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}
}

/********************************************Using Recursion*******************************************/
//Time Complexity : O(2^n),  n is the length of the candidates array
//Space Complexity : O(2^n *n), as a new list created at each recursive call
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using recursion, we have 2 choices, choose and don't choose
 * If the element is chosen, we add it to sum, and add it to the temp list
 * If the element is not chosen, we proceed with other elements
 * when the sum is equal to target, we append that list to the resultant list */

class Combination_Sum_Recurse {
	List<List<Integer>> result;
	int targ;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		targ = target;
		if(candidates == null || candidates.length == 0)
			return result;

		helper(candidates, new ArrayList<>(), 0, 0);
		return result;
	}

	private void helper(int[] candidates, List<Integer> temp, int sum, int index){
		//base
		if(sum > targ || index >= candidates.length)
			return;

		if(sum == targ){
			result.add(temp);
			return;
		}
		//logic
		//dont choose
		helper(candidates, new ArrayList<>(temp), sum, index + 1);	// new copy of temp is passed so that we don't loose the current state

		//choose
		temp.add(candidates[index]);
		helper(candidates, new ArrayList<>(temp), sum + candidates[index], index); 	 //sum is increased by choosed value, new copy of temp is passed so that we don't loose the current state
	}
}
