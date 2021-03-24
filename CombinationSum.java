// Time Complexity  : O(N^(T/M)) where n is the array length , T/M - height of the tree, T - target value , M - Minimum number of the array.
// Space Complexity : O(T/M) Using Recursion Stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }
    public void backtrack(int[] candidates,int target,int ind, List<Integer> temp){
        if(target == 0) result.add(new ArrayList<>(temp));
        else if(target < 0) return;
        for(int i=ind;i<candidates.length;i++){
            temp.add(candidates[i]);
          // Recursion by appending the values and altering the target
            backtrack(candidates,target-candidates[i],i,temp);
          // Backtrack to the previous state
            temp.remove(temp.size()-1);
        }
    }
}
