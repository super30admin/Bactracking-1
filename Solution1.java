//Time complexity: O(N^(T/M)), where N is the length of candidates and M is the minimum value in candidates array.
//Space complexity: O(T/M)

import java.util.*;

class Solution {
    int candidates[];
    List<List<Integer>> output = new ArrayList<>(); 
    public void backtrack(int start, List<Integer> combination, int target) {
        if(target == 0) {
            output.add(new ArrayList<Integer>(combination));
            return; 
        }
        for(int i=start; i<candidates.length; i++) {
            if(target - candidates[i] >= 0) {
                combination.add(candidates[i]);
                backtrack(i, combination, target-candidates[i]);
                combination.remove(combination.size()-1); 
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates; 
        backtrack(0, new ArrayList<>(), target);
        return output;
    }
}