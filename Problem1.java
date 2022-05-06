import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    //for loop recursion with back tracking
    // TC : exponential
    // SC : O (n) n is length of candidates
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, ArrayList<Integer> path) {
        //base case
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;
        //logic
        for (int i = index; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }

    //recursion solution
    // TC : exponential
    // SC : exponential
    class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return result;

            helper(candidates, target, 0, new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int target, int index, ArrayList<Integer> path) {
            //base case
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            if (target < 0 || index == candidates.length) {
                return;
            }

            //logic
            //System.out.println("target value " + target);
            helper(candidates, target, index + 1, path);
            path.add(candidates[index]);
            helper(candidates, target - candidates[index], index, path);
            path.remove(path.size() - 1);
        }
    }
}
