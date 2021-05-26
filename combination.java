import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n^n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class combination {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates, target, new ArrayList<>(), 0);
        return result;

    }
    private void backtrack(int[] candidates, int target, List<Integer> path, int i){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;

        }
        if(target < 0 || i == candidates.length){
            return;
        }

        backtrack(candidates, target, path, i+1);
        path.add(candidates[i]);
        backtrack(candidates, target - candidates[i], path, i);
        path.remove(path.size()-1);


    }
    
}
