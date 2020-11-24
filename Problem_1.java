// Time Complexity :(n ^ target)
// Space Complexity : Not sure 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Backtracking Solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        backtrack(candidates,target,0,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(int[] candidates, int target,int sum,List<Integer> temp,int index){
        //base
        if(sum == target) {
            result.add(new ArrayList<>(temp));
                return;
        }   
        if(sum > target) return;
        
        // logic
        for(int i=index;i<candidates.length;i++){
            // action
            temp.add(candidates[i]);
            // recurse
            backtrack(candidates,target,sum+candidates[i],temp,i);
            // backtrack
            temp.remove(temp.size()-1);
        }
    }
}

// Recursion Solution
// Time Complexity :(n ^ target)
// Space Complexity : Not sure 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        helper(candidates,target,0,new ArrayList<Integer>(),0);
        return result;
    }
    
    private void helper(int[] candidates, int target,int sum,List<Integer> temp,int i){
        //base
        if(sum>target || i>=candidates.length) return;
        if(sum == target) {
            result.add(temp);
                return;
        }
        
        //logic
        //not choose
        helper(candidates,target,sum,new ArrayList<>(temp),i+1);
        
        //choose
        temp.add(candidates[i]);
        helper(candidates,target,sum+candidates[i],new ArrayList<>(temp),i);
    }
}
