//Msst optimised in Method 3 - since we don't create a new ArrayList everytime.
// Though all 4 methods have same complexities, method 3 is preferred
// Time Complexity :O(2^(m*n)) - m is the number of candidates and n is the target
// Space Complexity :O(2^(m*n)) (everytime make a deep copy to new arraylist)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Method 4 - Using for-loop based recursion without backtracking
// TC: O(2^(m*n)) - m is the number of candidates and n is the target
// SC: O(2^(m*n)) (everytime make a deep copy to new arraylist)

class Solution {
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

        //for-lop based recursion
        //logic

        for(int i = pivot ; i < candidates.length ; i++) {

            List<Integer> temp = new ArrayList<>(path);
            //action
            temp.add(candidates[i]);

            //recursion
            helper(candidates,i,amount-candidates[i],temp);

            //backtrack
            //path.remove(path.size() -1);

        }
    }
}

//Method 3 - Using for-loop based recursion with backtracking
//TC: O(2^(m*n)) - m is the number of candidates and n is the target
//SC: O(2^(m*n)) (everytime make a new arraylist)
class Solution {
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

        //for-lop based recursion
        //logic

        for(int i = pivot ; i < candidates.length ; i++) {
            //action
            path.add(candidates[i]);

            //recursion
            helper(candidates,i,amount-candidates[i],path);

            //backtrack
            path.remove(path.size() -1);

        }
    }
}
//Method 2 - Backtracking
// TC: O(2^(m*n)) - m is the number of candidates and n is the target
// SC: O(2^(m*n)) (everytime make a deep copy to new arraylist)
class Solution {
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

//Method 1 - Using 0-1 recursion similar to coin change problem
//TC: O(2^(m*n)) - m is the number of candidates and n is the target
//SC: O(2^(m*n)) (everytime make a deep copy to new arraylist)
class Solution {
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
