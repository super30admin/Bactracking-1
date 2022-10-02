import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // Approach 1 - Using 0-1 recursion
    // TC: O(2^(m*n)) - m is the number of candidates and n is the target
    // SC: O(2^(m*n))
    static class Solution1 {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();

            if(candidates ==  null)
                return result;

            helper(candidates,0,target,new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int idx, int amount, List<Integer> path){

            //base case
            if(amount == 0){
                result.add(path);
                return;
            }

            if(amount < 0 || idx == candidates.length)
                return;

            //logic
            //not choose
            helper(candidates,idx+1,amount,new ArrayList(path));

            //choose
            path.add(candidates[idx]);
            helper(candidates,idx,amount-candidates[idx],new ArrayList(path));
        }
    }

    //Method 2 - Backtracking
    // TC - O(2^(m*n)) - m is the number of candidates and n is the target
    // SC - O(2^(m*n))
    static class Solution2 {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();

            if(candidates ==  null)
                return result;

            helper(candidates,0,target,new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int idx, int amount, List<Integer> path){

            //base case
            if(amount == 0){
                result.add(new ArrayList<>(path));
                return;
            }

            if(amount < 0 || idx == candidates.length)
                return;

            //logic
            //not choose
            helper(candidates,idx+1,amount,path);

            //choose
            //action
            path.add(candidates[idx]);

            //recursion
            helper(candidates,idx,amount-candidates[idx],path);

            //backtrack
            path.remove(path.size()-1);
        }
    }

    // Approach 3 - Using for-loop based recursion with backtracking
    // TC - O(2^(m*n)) - m is the number of candidates and n is the target
    // SC - O(2^(m*n))
    static class Solution3 {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();

            if(candidates ==  null)
                return result;

            helper(candidates,0,target,new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int pivot, int amount, List<Integer> path){

            //base case
            if(amount == 0){
                result.add(new ArrayList<>(path));
                return;
            }

            if(amount < 0)
                return;

            // logic - for-lop based recursion

            for(int i = pivot ; i < candidates.length ; i++) {
                // action
                path.add(candidates[i]);

                // recursion
                helper(candidates,i,amount-candidates[i],path);

                // backtrack
                path.remove(path.size() -1);

            }
        }
    }


    // Approach 4 - for-loop based recursion without backtracking
    // TC - O(2^(m*n)) - m is the number of candidates and n is the target
    // SC - O(2^(m*n))

    static class Solution4 {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();

            if(candidates ==  null)
                return result;

            helper(candidates,0,target,new ArrayList<>());
            return result;
        }

        private void helper(int[] candidates, int pivot, int amount, List<Integer> path){

            //base case
            if(amount == 0){
                result.add(new ArrayList<>(path));
                return;
            }

            if(amount < 0)
                return;

            // logic - for-lop based recursion

            for(int i = pivot ; i < candidates.length ; i++) {

                List<Integer> temp = new ArrayList<>(path);
                //action
                temp.add(candidates[i]);

                //recursion
                helper(candidates,i,amount-candidates[i],temp);

            }
        }
    }

}
