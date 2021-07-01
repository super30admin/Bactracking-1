import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(2^n)
 * // Space Complexity : O(2^n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    //List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates== null || candidates.length==0) return res;
        backtrack(candidates, 0, target, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] candidates, int index, int curr, List<Integer> path){
        //base
        if(curr==0) res.add(new ArrayList<>(path));
        //logic
        for(int i=index; i<candidates.length; i++){
            path.add(candidates[i]);
            if(curr-candidates[i]>=0)
                backtrack(candidates, i , curr-candidates[i], new ArrayList<>(path));
            path.remove(path.size()-1);
        }

    }
}