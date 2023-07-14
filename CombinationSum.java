// Time Complexity : O(2^(m+n)) where m is target and n is the number of elements in the candidates array
// Space Complexity :O(n) where n is the length of the candidates array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length < 1){
            return result;
        }

        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path){

        //base
        if(idx > candidates.length-1 || target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        //action
        path.add(candidates[idx]);
        //recurse
        helper(candidates, target-candidates[idx], idx, path);
        //backtrack
        path.remove(path.size()-1);
        helper(candidates, target, idx+1, path);
    }

    private void helper2(int[] candidates, int target, int pivot, List<Integer> path){

        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i< candidates.length; i++){
            path.add(candidates[i]);
            helper2(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}
