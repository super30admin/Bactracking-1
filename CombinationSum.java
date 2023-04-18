import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    //For loop based recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //For loop based recursion
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int pivot, int target, List<Integer> path) {
        //base
        if(pivot == candidates.length || target < 0) return;
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        for(int i = pivot; i<candidates.length; i++) {
            List<Integer> li = new ArrayList<>(path);
            li.add(candidates[i]);
            helper(candidates, i, target-candidates[i], li);
        }
    }

    //For loop based recursion using backtrack
    /*List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Backtracking
        result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int pivot, int target, List<Integer> path) {
        //base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot; i<candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            backtrack(candidates, i, target-candidates[i], path);
            //backtrack
            path.remove(path.size()-1);
        }
    }*/


    //0-1Recursion
    /*List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int idx, int target, List<Integer> path) {
        //base
        if(idx == candidates.length || target < 0) return;
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        //dont choose
        helper(candidates, idx+1, target, new ArrayList<>(path));

        //choose
        path.add(candidates[idx]);
        helper(candidates, idx, target-candidates[idx], new ArrayList<>(path));
    }*/


    //0-1 recursion using Backtracking
    /*List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Backtracking
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int idx, int target, List<Integer> path) {
        //base
        if(idx == candidates.length || target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //dont choose
        helper(candidates, idx+1, target, path);

        //choose
        //action
        path.add(candidates[idx]);
        //recurse
        helper(candidates, idx, target-candidates[idx], path);
        //backtrack
        path.remove(path.size()-1);
    }*/
}
