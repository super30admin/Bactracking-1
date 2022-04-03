// Time Complexity : O(2^(target/minCandidate))
// Space Complexity : O(target/minCandidate)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can solve this using select or not select approach
// If we select we will decrement the target
// If we don't select we can increment the index and move to next element
// We will also backtrack after the selection recursive call and check for next element

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        combinationsSum(candidates, target, 0, new ArrayList<>());
        return ans;
    }
    private void combinationsSum(int [] candidates, int target, int index, List<Integer> curr){
        
        //base
        if(target < 0 || index >= candidates.length)
            return;
        if(target == 0){
            List<Integer> ll = new ArrayList<>(curr);
            ans.add(ll);
            return;
        }
        //select
        int val = candidates[index];
        curr.add(val);
        //recurse
        combinationsSum(candidates, target-val, index, curr);
        //backtrack
        curr.remove(curr.size()-1);
        
        //not select
        combinationsSum(candidates, target, index+1, curr);
    }
}