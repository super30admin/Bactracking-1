// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CombinationSum {
    class Solution {
        private List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.result = new ArrayList<>();
            helper(candidates, target, 0, new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int target, int pivot, List<Integer> path){
            //base case
            if(target == 0){
                result.add(new ArrayList(path));
                return;
            }
            if(target < 0 || pivot >= candidates.length)
                return;

            //logic
            for(int i = pivot; i < candidates.length; i++){
                //action
                path.add(candidates[i]);

                //recurse
                helper(candidates, target - candidates[i], i, path);

                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

}
