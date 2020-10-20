// Time Complexity : O(M^N)
// Space Complexity : O(N) N - length of longest possible combination
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using Backtracking approach

class Solution {
    List<List<Integer>> output = new ArrayList<>();
   // List<Integer> subArray = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        Arrays.sort(candidates);
        helper(0, candidates, target,new ArrayList<Integer>(), 0);
        return output;
    }
    
    private void helper(int sum, int[] candidates, int target, ArrayList<Integer> subArray, int index){
        if(sum > target)
            return;  
        if(sum == target){
            output.add(new ArrayList<Integer>(subArray));
            return;
        }
        
        
        for(int i = index; i < candidates.length; i++){
           //sum += candidates[i];
           
            subArray.add(candidates[i]);
           
            helper(sum+candidates[i], candidates, target, subArray, i);
           
            subArray.remove(subArray.size()-1);
        }  
    }
}


