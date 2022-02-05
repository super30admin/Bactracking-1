import java.util.ArrayList;
import java.util.List;

// Time Complexity : Add : O(2^(m+n))   
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CombinationSum_ForLoopBacktrack {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates, target);
    }

    static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }

    private static void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target<0 || index>=candidates.length)
            return;

        //logic
        for(int i=index; i<candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, i, path, target-candidates[i]);
            path.remove(path.size()-1); //backtrack`
        }
     }
}

