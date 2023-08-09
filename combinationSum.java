// Time Complexity : O(2^n), n is the length of the candidates array
// Space Complexity : O(n), n is the length of the candidates array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Idea is pick and not pick an element at each index and recurse.
 * 2. If you pick and element add it to list and reduce the target by element value and stay at the same index.
 * 3. If you don't pick an element, just move to next index.
 * 4. If target is 0, add the list to result.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sum(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void sum(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> res){
        if(index >= candidates.length || target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(candidates[index]);
        sum(candidates, index, target-candidates[index], list, res);
        list.remove(list.size()-1);
        sum(candidates, index+1, target, list, res);
    }
}