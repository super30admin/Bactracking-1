// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;


//TC: O(2^n)
//SC: O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        // helperRecursion(candidates, target, new ArrayList<>(), 0);
        helperIterativeRecursion(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void helperRecursion(int[] candidates, int target, List<Integer> path, int idx) {

        //Base
        if(target == 0) {
            result.add(path);
            return;
        }

        if(target < 0 || idx == candidates.length) {
            return;
        }

        //logic
        // List<Integer> li = new ArrayList<>(path);
        // li.add(candidates[idx]);

        path.add(candidates[idx]);

        //choose
        // helperRecursion(candidates, target - candidates[idx], li, idx);
        helperRecursion(candidates, target - candidates[idx], path, idx);
        path.remove(path.size() - 1);

        //Don't choose
        // helperRecursion(candidates, target, li, idx + 1);
        helperRecursion(candidates, target, path, idx + 1);
    }

     private void helperIterativeRecursion(int[] candidates, int target, List<Integer> path, int pivot) {
         //base
         if(target == 0) {
             result.add(new ArrayList<>(path));
             return;
         }

         if(target < 0) {
             return;
         }

         //logic
         for(int i = pivot; i < candidates.length; i++) {
             path.add(candidates[i]); //action
             helperIterativeRecursion(candidates, target - candidates[i], path, i); //recurse
             path.remove(path.size() -1 ); //backtrack
         }

    }
}