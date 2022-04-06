/**
 * time complexity is exponential
 * space complexity is exponential
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helper(int[] candidates, int index, List<Integer> path, int target) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, path, target-candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}