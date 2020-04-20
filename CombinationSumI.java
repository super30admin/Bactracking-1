// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int remaining = target;
        int startIndex = 0;
        backtrack(result, candidates, new ArrayList<Integer>(), remaining, startIndex);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates, ArrayList<Integer> temp, int remaining, int startIndex){
        if(remaining < 0){
            return;
        } else if (remaining == 0){
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = startIndex ; i < candidates.length; i++){
                temp.add(candidates[i]);
                backtrack(result, candidates, temp, remaining - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
