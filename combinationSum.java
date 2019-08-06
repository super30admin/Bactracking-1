//idea:  recrusive solution-backtracking
//iterate whole array and substract each element from target and add into list.The result of subtraction will be new target value.
//again recursively pass new target value and iterate whole array till target is less than element in array.
//if target value is 0 then add list to result list

//time complexity o(n2)  for every element we are checking whole array through recusively
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

	 
			public List<List<Integer>> combinationSum(int[] candidates, int target) {
				List<List<Integer>> result = new ArrayList();
				backtracking(candidates, target, 0, new ArrayList(), result);
				return result;
			}

			void backtracking(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
				if (target > 0) {
					for (int i = start; i < candidates.length; i++) {
						if (candidates[i] > target) {
							continue;// pruning
						}
						curr.add(candidates[i]);
						backtracking(candidates, target - candidates[i], i, curr, result);//list=[2,2,2] if input=[2,3,6,7]
						curr.remove(curr.size() - 1); //list =[2,2]once target is greater than candiate[i] for loop inside backtracking will get complete and control will come to this line
					}
				} else if (target == 0) {
					result.add(new ArrayList(curr));
				}
			}
		
}
