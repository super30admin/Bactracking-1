package backtracking1;

// Idea: Recursively we choose from small to large recursively, every time we add a candidate to our possible sub result, 
//       we subtract the target to a new smaller one.

// TC : O(2^n) where n is the number of candidates array
// SC : 

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        //Arrays.sort(candidates);
        
        backtracking(candidates, target, 0, result, new ArrayList<>());
        
        return result;
    }
    
    void backtracking(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> curr) {
        if(target > 0) {
            for(int i = start; i < candidates.length; i++) {
                
                if(candidates[i] > target) {
                    
                    continue;
                }
                curr.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i, result, curr);
                
                curr.remove(curr.size() - 1);
            }
        }
        else if (target == 0) {
            result.add(new ArrayList<>(curr));
        }
    }
}
