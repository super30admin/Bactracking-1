import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	// Time Complexity : Exponential 
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using recursion method.
	 * Here, 2 scenarios are considered each time(i.e., choose and no choose of the value from int []).
	 * along with this new list of array will be getting created to store the path undergone until the target becomes 0.
	 */
	// Recursive method
	List<List<Integer>> result1;
	public List<List<Integer>> combinationSumRecursive(int[] candidates, int target) {
        result1 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result1;
        helper1(candidates, 0, new ArrayList<>(), target);
        return result1;
    }
	
	private void helper1(int[] candidates, int i, List<Integer> path, int target){
		//base
		if(i == candidates.length || target < 0)return;
		if(target == 0){
			result1.add(path);
			return;
		}
		//logic
		//no choose
		helper1(candidates, i + 1, new ArrayList(path), target);
		//choose
		path.add(candidates[i]);
		helper1(candidates, i, new ArrayList(path), target - candidates[i]);
	}
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using Backtracking method.
	 * Here, 2 scenarios are considered each time(i.e., choose and no choose of the value from int []).
	 * along with this new list of array will not be getting created every time the path is stored but the last item will be removed 
	 * and the recursion shall be continued until the target reaches 0.
	 */
	//Backtracking method
	List<List<Integer>> result2;
	public List<List<Integer>> combinationSumBacktracking(int[] candidates, int target) {
        result2 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result2;
        helper2(candidates, 0, new ArrayList<>(), target);
        return result2;
    }
	
	private void helper2(int[] candidates, int i, List<Integer> path, int target){
		//Action
		//base
		if(i == candidates.length || target < 0)return;
		if(target == 0){
			result2.add(new ArrayList(path));
			return;
		}
		//Recurse
		//logic
		//no choose
		helper2(candidates, i + 1, path, target);
		//choose
		path.add(candidates[i]);
		helper2(candidates, i, path, target - candidates[i]);
		//Backtrack
		path.remove(path.size() - 1);
		
	}
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using Iterative method where the recursion happens in the loop and then backtracked.
	 * Here, 2 scenarios are considered each time(i.e., choose and no choose of the value from int []).
	 * along with this new list of array will not be getting created every time the path is stored but the last item will be removed 
	 * and the recursion shall be continued until the target reaches 0.
	 */
	
	//Iterative backtracking
	List<List<Integer>> result3;
	public List<List<Integer>> combinationSumIterativeBacktrack(int[] candidates, int target) {
        result3 = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result3;
        helper3(candidates, 0, new ArrayList<>(), target);
        return result3;
    }
	
	private void helper3(int[] candidates, int index, List<Integer> path, int target){
		//Action
		//base
		if(target < 0)return;
		if(target == 0){
			result3.add(new ArrayList(path));
			return;
		}
		for(int i = index; i < candidates.length; i++){
			//action
			List<Integer> temp = new ArrayList(path);
			//recurse
			temp.add(candidates[i]);
			helper3(candidates, i, temp, target - candidates[i]);
			//backtrack
			temp.remove(temp.size() - 1);
		}
		
	}
	
}
